package cec.ics.module.dto;

import cec.ics.module.entity.TcInoutls;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

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
@ApiModel(value="TcInoutlsDTO对象", description="DTO")
public class TcInoutlsDTO extends TcInoutls {

    private static final long serialVersionUID = 1L;

	/** 
	 * <p>Title:获取entity对象</p>
	 * <p>Description:</p>
	 * @author zrh
	 * @date 2020-05-11
	 * @version 1.0 
	 * @return
	 */
	public TcInoutls toTcInoutls() {
    	TcInoutls tcInoutls = new TcInoutls();
    	BeanUtils.copyProperties(this, tcInoutls);
    	return tcInoutls;
    }
}
