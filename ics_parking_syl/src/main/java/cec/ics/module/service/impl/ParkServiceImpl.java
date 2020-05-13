package cec.ics.module.service.impl;

import cec.ics.module.entity.CountTcInOut;
import cec.ics.module.entity.parking.*;
import cec.ics.module.entity.response.TcInOutLsResp;
import cec.ics.module.mapper.TcInoutlsMapper;
import cec.ics.module.service.ParkService;
import cec.ics.module.vo.TcInOutLsVo;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName ParkServiceImpl
 * @Author ZRH
 * @Date 2020/5/10 0010 11:00
 * @Version
 **/

@Service
public class ParkServiceImpl implements ParkService {

    @Autowired
    private TcInoutlsMapper tcInoutlsMapper;

    @Override
    public Map<String, SumData> getSumMap() {

        Map<String, SumData> map = new HashMap<>(3);
        SumData sumData1 = new SumData();
        //近七日收费汇总
        sumData1.setData(countEarning("day"));
        map.put("sevenCharges", sumData1);
        //近12个月收费汇总
        SumData sumData2 = new SumData();
        sumData2.setData(countEarning("month"));
        map.put("twelveCharges", sumData2);
        //当天当前时刻之前的每小时车辆进出汇总
        List<CountTcInOut> ins = tcInoutlsMapper.countTcIn();
        SumData sumData3 = new SumData();
        sumData3.setCarInNum(handlerTimeData(ins));
        List<CountTcInOut> outs = tcInoutlsMapper.countTcOut();
        sumData3.setCarOutNum(handlerTimeData(outs));
        map.put("inOutNums", sumData3);
        return map;
    }

    /**
     * 暂不具备该功能
     * @return
     */
    @Override
    public Map<String,Double> getPackingUsed() {

        //查询当前车库车辆数量
        Map<String,Double> map = new HashMap<>(1);
        map.put("used",0.0);
        return map;
    }

    @Override
    public IPage<TcInOutLsResp> inOutList(TcInOutLsVo tcInOutLsVo) {
        Page<TcInOutLsResp> tcInOutLsDTOPage = new Page<>(tcInOutLsVo.getPageNum(), tcInOutLsVo.getPageSize());
        return tcInoutlsMapper.pageTcInOut(tcInOutLsDTOPage, tcInOutLsVo);
    }

    @Override
    public TcInOutLsResp inOutDetail(String id) {
        TcInOutLsVo tcInOutLsVo = new TcInOutLsVo();
        tcInOutLsVo.setId(Integer.parseInt(id));
        Page<TcInOutLsResp> tcInOutLsDTOPage = new Page<>(1, 10);
        return tcInoutlsMapper.pageTcInOut(tcInOutLsDTOPage, tcInOutLsVo).getRecords().get(0);
    }

    @Override
    public IPage<CarSumDo> chargeSumList(CarSumVo carSumVo) {
        Page<CarSumDo> tcInOutLsRespPage = new Page<>(carSumVo.getPageNum(), carSumVo.getPageNum());
        return tcInoutlsMapper.listTcEarSum(tcInOutLsRespPage, carSumVo);
    }

    /**
     * 收费汇总
     * @param type
     * @return
     */
    private List<Double> countEarning(String type) {
        CarSumVo carSumVo = new CarSumVo();
        int num = 0;
        carSumVo.setSumType(type);
        if ("month".equals(type)) {
            num = 12;

            //置入开始和结束时间
            listTwelveMonth(carSumVo);
        } else {
            num = 7;
            listSevenDay(carSumVo);
        }
        Page<TcInOutLsResp> tcInOutLsDTOPage = new Page<>(1, 24);

        //查询规定时间范围内的数据
        List<CarSumDo> list = tcInoutlsMapper.listTcEarSum(tcInOutLsDTOPage, carSumVo).getRecords();
        if ("month".equals(type)) {
            for (CarSumDo c : list) {
                String s = StringUtils.substringAfter(c.getDateTime(), "-");
                if (Integer.parseInt(s) < 10) {
                    s = "0" + s;
                }
                c.setDateTime(StringUtils.substringBefore(c.getDateTime(), "-") + "-" + s + "-01");
            }
        }

        //数据补齐
        dataComplement(list, type);

        //对数据进行逆序排序,并取前几条数据
        List<CarSumDo> collect = list.stream().sorted((a, b) -> {
            DateTime aparse = DateUtil.parse(a.getDateTime());
            DateTime bparse = DateUtil.parse(b.getDateTime());
            if (aparse.isBefore(bparse)) {
                return 1;
            }
            return -1;
        }).limit(num).collect(Collectors.toList());

        //正排序
        Collections.reverse(collect);
        //返回实付金额
        return collect.stream().map(c -> c.getSumCase()).collect(Collectors.toList());
    }

    /**
     * 补齐已过时段中无数据的时段数据
     *
     * @param list
     * @return
     */
    private List<Integer> handlerTimeData(List<CountTcInOut> list) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        int currentHours = instance.get(Calendar.HOUR_OF_DAY);
        for (int i = 0; i <= currentHours; i++) {
            boolean have = false;
            for (CountTcInOut c : list) {
                if (c.getHourNum() == i) {
                    have = true;
                    break;
                }
            }
            if (!have) {
                CountTcInOut countTcInOut = new CountTcInOut();
                countTcInOut.setHourNum(i);
                countTcInOut.setNum(0);
                list.add(countTcInOut);
            }
        }
        //按照时间段正序后返回车辆数
        return list.stream().sorted((c1, c2) -> c1.getHourNum().compareTo(c2.getHourNum())).map(CountTcInOut::getNum).collect(Collectors.toList());
    }

    /**
     * 获取近7日的时间字符串
     *
     * @param carSumVo
     * @return
     */
    private List<String> listSevenDay(CarSumVo carSumVo) {

        List<String> timeStr = new ArrayList<>(7);
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        for (int i = 0; i < 7; i++) {
            Date time = instance.getTime();
            if (null != carSumVo) {
                if (i == 0) {
                    carSumVo.setEndTime(new Date());
                }
                if (i == 6) {
                    carSumVo.setBeginTime(DateUtil.beginOfDay(time));
                }
            }
            timeStr.add(DateUtil.formatDate(time));
            instance.add(Calendar.DAY_OF_MONTH, -1);
        }
        return timeStr;
    }

    /**
     * 返回近12月时间字符串
     *
     * @param carSumVo
     * @return
     */
    private List<String> listTwelveMonth(CarSumVo carSumVo) {
        List<String> timeStr = new ArrayList<>(12);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        for (int i = 0; i < 12; i++) {
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            StringBuilder str = new StringBuilder();
            if (month < 10) {
                str.append(year).append("-").append("0").append(month).append("-01");
            } else {
                str.append(year).append("-").append(month).append("-01");
            }
            //获取时间段的开始和结束时间
            if (null != carSumVo) {
                if (i == 0) {
                    carSumVo.setEndTime(new Date());
                }
                if (i == 11) {
                    carSumVo.setBeginTime(DateUtil.parse(str));
                }
            }

            timeStr.add(str.toString());
            calendar.add(Calendar.MONTH, -1);
        }
        return timeStr;
    }

    /**
     * 补齐近7日或近12月的数据
     * @param list
     * @param type
     */
    private void dataComplement(List<CarSumDo> list, String type) {
        List<String> strings = new ArrayList<>(10);
        List<CarSumDo> newStrs = new ArrayList<>(10);
        if ("month".equals(type)) {
            strings = listTwelveMonth(null);

        } else if ("day".equals(type)) {
            strings = listSevenDay(null);
        }
        for (String s : strings) {
            boolean have = false;
            for (CarSumDo c : list) {
                if (c.getDateTime().equals(s)) {
                    have = true;
                    break;
                }
            }

            if (!have) {
                CarSumDo carSumDo = new CarSumDo();
                carSumDo.setDateTime(s);
                carSumDo.setSumCase(0.0);
                newStrs.add(carSumDo);
            }
        }

        list.addAll(newStrs);
    }

}
