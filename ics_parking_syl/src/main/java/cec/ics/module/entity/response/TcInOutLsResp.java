package cec.ics.module.entity.response;

import cec.ics.module.entity.parking.TcInOutLsDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName TcInOutLsDTO
 * @Description
 * @Author ZRH
 * @Date 2020/4/21 0021 9:11
 * @Version 1.3
 **/

@Data
public class TcInOutLsResp extends TcInOutLsDO {

    @ApiModelProperty(name = "收费类型名称")
    String payType;

    @ApiModelProperty(name = "收费金额")
    Double factCash;

    @ApiModelProperty(name = "车辆类型名称")
    private String carType;

    @ApiModelProperty(value = "车牌颜色")
    private String Color;


}
