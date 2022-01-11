package com.common.ctrl;

import com.common.base.result.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Api(tags = "版本")
@RestController
@RequestMapping("/version")
public class VersionCtrl
{
    @Value("${app.build.time}")
    private String buildTime;
    @Value("${app.version}")
    private String version;

    @ApiOperation(value = "版本信息")
    @GetMapping(path = { "/info" })
    public ResponseResult info()
    {
        HashMap info = new HashMap<>();
        info.put("version", version);
        info.put("buildTime", buildTime);
        return ResponseResult.ok(info);
    }
}
