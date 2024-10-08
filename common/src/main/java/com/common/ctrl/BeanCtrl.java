package com.common.ctrl;

import com.common.base.result.ResponseResult;
import com.common.biz.BeanManager;
import com.common.data.BeanData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Bean容器数据展示
 *
 * @author hjx
 * @version 1.0
 * @date 2021/7/11 22:12
 */
@Api(tags = "Bean容器")
@RestController
@RequestMapping("/bean")
@Slf4j
public class BeanCtrl
{
    @Autowired
    private BeanManager beanManager;

    @ApiOperation(value = "获取全部Bean")
    @GetMapping(path = { "" })
    public ResponseResult<List<BeanData>> data()
    {
        log.info("获取全部Bean");
        return ResponseResult.ok(beanManager.get());
    }

}
