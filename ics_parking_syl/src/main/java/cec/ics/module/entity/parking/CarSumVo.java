package cec.ics.module.entity.parking;

import cec.ics.module.vo.BasePage;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @ClassName CarSumVo
 * @Author ZRH
 * @Date 2020/4/21 0021 14:25
 * @Version
 **/
@Getter
@Setter
public class CarSumVo extends BasePage {

    //查询类型
    String sumType;

    //该时间的数据
    Date time;

    //开始时间
    Date beginTime;


    //结束时间
    Date endTime;


}
