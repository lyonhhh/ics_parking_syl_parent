package cec.ics.module.entity;

import cec.system.base.basic.entity.BasicNoneEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author zrh
 * @since 2020-05-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("TC_Inoutls")
@ApiModel(value="TcInoutls对象", description="")
public class TcInoutls extends BasicNoneEntity {

    private static final long serialVersionUID = 1L;

    @TableField("P_KEY")
    private Integer pKey;

    @TableField("Carno")
    private String Carno;

    @TableField("CLLX")
    private Integer cllx;

    @TableField("SFLX")
    private Integer sflx;

    @TableField("CPLX")
    private Integer cplx;

    @TableField("CardNo")
    private String CardNo;

    @TableField("I_CtrlNO")
    private String iCtrlno;

    @TableField("O_CtrlNo")
    private String oCtrlno;

    @TableField("I_CCBH")
    private Integer iCcbh;

    @TableField("O_CCBH")
    private Integer oCcbh;

    @TableField("I_TDBH")
    private Integer iTdbh;

    @TableField("O_TDBH")
    private Integer oTdbh;

    @TableField("In_time")
    private LocalDateTime inTime;

    @TableField("Out_time")
    private LocalDateTime outTime;

    @TableField("I_PicNo")
    private String iPicno;

    @TableField("O_PicNo")
    private String oPicno;

    @TableField("I_Gate")
    private Integer iGate;

    @TableField("O_Gate")
    private Integer oGate;

    @TableField("I_GetData")
    private Integer iGetdata;

    @TableField("O_GetData")
    private Integer oGetdata;

    @TableField("Inout_Type")
    private Integer inoutType;

    @TableField("I_Oper")
    private String iOper;

    @TableField("O_Oper")
    private String oOper;

    @TableField("OuterType")
    private Integer OuterType;

    @TableField("M_KEY")
    private Integer mKey;

    @TableField("I_TGLX")
    private Integer iTglx;

    @TableField("O_TGLX")
    private Integer oTglx;

    @TableField("ReMark")
    private String ReMark;

    @TableField("I_GTBH")
    private Integer iGtbh;

    @TableField("I_CDMC")
    private String iCdmc;

    @TableField("O_GTBH")
    private Integer oGtbh;

    @TableField("O_CDMC")
    private String oCdmc;

    @TableField("SFLXZH")
    private Integer sflxzh;

    @TableField("SFZHSJ")
    private LocalDateTime sfzhsj;

    @TableField("I_KZJH")
    private Integer iKzjh;

    @TableField("O_KZJH")
    private Integer oKzjh;

    @TableField("Balance")
    private Integer Balance;

    private Integer carColor;

    @TableField("BL_OrderNo")
    private String blOrderno;

    @TableField("BL_KEY")
    private String blKey;

    @TableField("JH_parkOrderNo")
    private String jhParkorderno;

    @TableField("PP_OrderNo")
    private String ppOrderno;

    @TableField("PP_SeriaNo")
    private String ppSeriano;

    @TableField("PP_CardID")
    private String ppCardid;


}
