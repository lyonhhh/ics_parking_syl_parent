package cec.ics.module.entity.parking;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @ClassName SumData
 * @Author ZRH
 * @Date 2020/4/21 0021 15:03
 * @Version
 **/
@Getter
@Setter
public class SumData {


    List<Double> data;

    List<Integer> carOutNum;

    List<Integer> carInNum;
}
