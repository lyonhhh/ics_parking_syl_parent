package cec.ics.module.mapper;

import cec.ics.module.entity.CountTcInOut;
import cec.ics.module.entity.parking.CarSumDo;
import cec.ics.module.entity.parking.CarSumVo;
import cec.ics.module.entity.parking.TcEarningDO;
import cec.ics.module.entity.response.TcInOutLsResp;
import cec.ics.module.entity.TcInoutls;
import cec.ics.module.entity.parking.TcInOutLsDO;
import cec.ics.module.vo.TcInOutLsVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zrh
 * @since 2020-05-11
 */
public interface TcInoutlsMapper extends BaseMapper<TcInoutls> {

    IPage<TcInOutLsResp> pageTcInOut(Page<?> page,@Param("tcInOutLsVo") TcInOutLsVo tcInOutLsVo);

    IPage<CarSumDo> listTcEarSum( Page<?> page,@Param("carSumVo") CarSumVo carSumVo);

    List<CountTcInOut> countTcIn();

    List<CountTcInOut> countTcOut();
}
