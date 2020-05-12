package cec.ics.module.controller;


import cec.common.web.Result;
import cec.ics.module.entity.parking.CarSumDo;
import cec.ics.module.entity.parking.CarSumVo;
import cec.ics.module.entity.parking.SumData;
import cec.ics.module.entity.response.TcInOutLsResp;
import cec.ics.module.service.ParkService;
import cec.ics.module.vo.TcInOutLsVo;
import cec.system.base.basic.controller.BasicController;
import cec.system.base.mvc.dto.RequestBodyDTO;
import cec.system.manager.annotation.InterfaceAutoRegister;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName ParkingSylController
 * @Author ZRH
 * @Date 2020/5/10 0010 10:49
 * @Version
 **/
@RestController
@RequestMapping(value = "parking")
@Api(value = "石杨路停车子系统模块")
@InterfaceAutoRegister(valid = InterfaceAutoRegister.ValidType.NONE)
public class ParkingSylController extends BasicController {

    @Autowired
    private ParkService parkService;

    @PostMapping(value = "getSumMap")
    @ApiOperation(value = "获取首页统计图")
    public Result<Map<String, SumData>> getSumMap() {
        return Result.success(parkService.getSumMap());
    }

    @PostMapping(value = "getPackingUsed")
    @ApiOperation(value = "获取当前车库占用率")
    public Result<Double> getPackingUsed() {
        return Result.success(parkService.getPackingUsed());
    }

    @PostMapping(value = "inOutList")
    @ApiOperation(value = "车辆出入信息分页数据")
    public Result<IPage<TcInOutLsResp>> inOutList(@RequestBody RequestBodyDTO<TcInOutLsVo> tcInOutLsVo) {
        IPage<TcInOutLsResp> tcInOutLsRespIPage = parkService.inOutList(tcInOutLsVo.getData());
        return Result.success(tcInOutLsRespIPage);
    }

    @PostMapping(value = "inOutDetail")
    @ApiOperation(value = "车辆出入信息详情")
    public Result<TcInOutLsResp> inOutDetail(@RequestBody RequestBodyDTO<Map<String, String>> body) {
        return Result.success(parkService.inOutDetail(body.getData().get("id")));
    }

    @PostMapping(value = "chargeSumList")
    @ApiOperation(value = "道闸收费汇总")
    public Result<IPage<CarSumDo>> chargeSumList(@RequestBody RequestBodyDTO<CarSumVo> carSumVo) {
        return Result.success(parkService.chargeSumList(carSumVo.getData()));
    }
}
