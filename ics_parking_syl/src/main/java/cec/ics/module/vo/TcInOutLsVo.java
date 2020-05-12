package cec.ics.module.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName TcInOutLsVo
 * @Author ZRH
 * @Date 2020/4/21 0021 11:13
 * @Version
 **/
@Getter
@Setter
public class TcInOutLsVo extends BasePage {

    @ApiModelProperty(name = "车牌号码")
    private String carno;

    @ApiModelProperty(name = "驶入时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date inTime;



    @ApiModelProperty(name = "驶出时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date outTime;

    //车辆出入记录主键
    private Integer id;

}
