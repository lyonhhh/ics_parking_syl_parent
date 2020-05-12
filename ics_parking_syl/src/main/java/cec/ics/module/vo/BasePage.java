package cec.ics.module.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName BasePage
 * @Author ZRH
 * @Date 2020/4/21 0021 14:26
 * @Version
 **/
@Getter
@Setter
public class BasePage {

    private Integer pageNum = 1;
    private Integer pageSize = 10;
}
