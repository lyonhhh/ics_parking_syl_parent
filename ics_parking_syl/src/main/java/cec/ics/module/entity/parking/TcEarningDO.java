package cec.ics.module.entity.parking;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class TcEarningDO {

    private Integer pKey;


    private String carno;


    private String iCtrlno;


    private String oCtrlno;


    private Integer iCcbh;


    private Integer oCcbh;


    private Integer iTdbh;


    private Integer oTdbh;


    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date inTime;


    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date outTime;


    private Double sumCash;


    private Double factCash;


    private Integer sfType;


    private Integer tglx;


    private String cNo;


    private String oper;


    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date operdate;


    private String remark;


    private String cItem;


    private String cName;


    private String bCode;


    private Integer iGtbh;


    private String iCdmc;


    private Integer oGtbh;


    private String oCdmc;



//    @JsonSerialize(using = PayTypeToLabel.class)
    private Integer paytype;

    private String payType;


    private Integer tradetype;


    private String tradeno;


    private String transid;


    private Integer sflxzh;


    private Integer online;


    private String sfCode;

}