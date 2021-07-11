package com.common.ctrl;

import com.common.base.result.ResponseResult;
import com.common.biz.BeanManager;
import com.common.data.BeanData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Bean容器数据展示
 *
 * @author hjx
 * @version 1.0
 * @date 2021/7/11 22:12
 */
@RestController
@RequestMapping("/bean")
public class BeanCtrl
{
    @Autowired
    private BeanManager beanManager;

    @GetMapping(path = { "", "/" })
    public ResponseResult<BeanData> data()
    {
        BeanData beanData = beanManager.get();
        return ResponseResult.ok(beanData);
    }

}
