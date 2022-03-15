package com.common.ctrl;

import com.common.base.result.ResponseResult;
import com.common.biz.opi.ISeckillService;
import com.common.data.Exposer;
import com.common.model.Seckill;
import com.common.model.SeckillLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hjx
 * @version 1.0
 * @date 2021/12/2 23:02
 */
@Api(tags = "商品秒杀")
@RestController
@RequestMapping("/buy")
public class SeckillCtrl
{
    @Autowired
    private ISeckillService service;

    @ApiOperation(value = "初始化,模拟秒杀商品")
    @GetMapping(path = { "/mock" })
    public ResponseResult<Long> init()
    {
        return ResponseResult.ok(service.mockData());
    }

    @ApiOperation(value = "查看列表")
    @GetMapping(path = { "/list" })
    public ResponseResult<List<Seckill>> list()
    {
        return ResponseResult.ok(service.getSeckillList());
    }

    @ApiOperation(value = "开启秒杀")
    @GetMapping(path = { "/start/{id}" })
    public ResponseResult<Exposer> start(@PathVariable long id)
    {
        return ResponseResult.ok(service.exportSeckillUrl(id));
    }

    @ApiOperation(value = "秒杀")
    @GetMapping(path = { "/execute" })
    public ResponseResult<SeckillLog> execute(long seckillId, String userPhone, String md5)
    {
        return ResponseResult.ok(service.executeSeckill(seckillId, userPhone, md5));
    }
}
