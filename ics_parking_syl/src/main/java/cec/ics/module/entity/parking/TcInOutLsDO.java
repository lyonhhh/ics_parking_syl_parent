package cec.ics.module.entity.parking;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class TcInOutLsDO {

    @ApiModelProperty(value = "出入记录id")
    private String id;

    @ApiModelProperty(value = "车牌号码")
    private String carno;

    @ApiModelProperty(value = "车辆类型")
    private Integer cllx;

    @ApiModelProperty(value = "收费类型")
    private Integer sflx;

    @ApiModelProperty(value = "卡号")
    private String cardno;


    @ApiModelProperty(value = "驶入时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date inTime;


    @ApiModelProperty(value = "驶出时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date outTime;


    @ApiModelProperty(value = "备注")
    private String remark;


//    @ApiModelProperty(value = "车牌颜色")
//    private Integer carColor;


}