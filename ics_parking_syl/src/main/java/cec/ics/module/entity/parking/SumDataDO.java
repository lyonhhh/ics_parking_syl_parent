package cec.ics.module.entity.parking;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @ClassName SumDataDO
 * @Author ZRH
 * @Date 2020/4/21 0021 14:01
 * @Version
 **/
@Setter
@Getter
public class SumDataDO {
    @ApiModelProperty(value = "汇总数据")
    Map<String,SumData> sumDatas;
}
