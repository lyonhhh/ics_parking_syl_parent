package cec.ics.module.entity.parking;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Classvalue CarSumDo
 * @Description
 * @Author ZRH
 * @Date 2020/4/21 0021 9:11
 * @Version 1.3
 **/

@Data
public class CarSumDo {


    @ApiModelProperty(value = "日期")
    String dateTime;


    @ApiModelProperty(value = "进场车辆数量")
    Integer inCarNum;

    @ApiModelProperty(value = "出场车辆数量")
    Integer outCarNum;


    @ApiModelProperty(value = "停车场使用时间")
    Integer parkTime;


    @ApiModelProperty(value = "实收总额")
    Double sumCase;

}
