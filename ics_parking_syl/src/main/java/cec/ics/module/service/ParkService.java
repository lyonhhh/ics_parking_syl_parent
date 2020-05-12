package cec.ics.module.service;

import cec.ics.module.entity.parking.SumData;
import cec.ics.module.entity.response.TcInOutLsResp;
import cec.ics.module.entity.parking.CarSumDo;
import cec.ics.module.entity.parking.CarSumVo;
import cec.ics.module.entity.parking.SumDataDO;
import cec.ics.module.vo.TcInOutLsVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ParkService
 * @Description
 * @Author ZRH
 * @Date 2020/5/10 0010 10:59
 * @Version 1.0
 **/
public interface ParkService {

    Map<String,SumData> getSumMap();

    Double getPackingUsed();

    IPage<TcInOutLsResp> inOutList(TcInOutLsVo tcInOutLsVo);

    TcInOutLsResp inOutDetail(String carNo);

    IPage<CarSumDo> chargeSumList(CarSumVo carSumVo);
}
