package com.common.ctrl;

import com.common.base.result.ResponseResult;
import com.common.data.CommonColumnData;
import com.common.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * API接口，增加注解自动生成文档
 *
 * @ApiImplicitParam 适用于简单描述参数
 * paramType : header query path body form
 * dataType:String  Integer
 * @return ResponseResult<User>
 * @ApiResponse 适用于简单描述参数
 * @ApiModel+ApiModelProperty适用于复杂对象说明
 *
 * 备注：@example适用于 query path form ；@examples适用于body 但是UI有bug无法展示。
 * 所以针对body参数，不建议使用@example 而应该使用vo对象
 */
@Api(tags = "在线API文档Demo")
@RestController
@RequestMapping("/apidemo")
public class ApiDemoCtrl
{
    /**
     * @ApiParam.example属性 有效
     */
    @ApiOperation(value = "@ApiParamQuery")
    @GetMapping(path = { "/ApiParamQuery" })
    public ResponseResult<CommonColumnData> testApiParamQuery(
            @ApiParam(required = true, value = "{'columnName':'代码表名','searchContition':'筛选条件'}", example = "{\"columnName\":\"ADDRESS\",\"searchContition\":\"北\"}")
            @RequestParam String param)
    {
        return ResponseResult.ok();
    }
    /**
     * @ApiImplicitParam.example属性 有效
     */
    @ApiOperation(value = "@ApiImplicitParamQuery")
    @GetMapping(path = { "/ApiImplicitParamQuery" })
    @ApiImplicitParam(name = "id", required = true, dataType = "Integer", paramType = "query", value = "ID", example = "101")
    @ApiResponses(@ApiResponse(code = 200, message = "data=>User"))
    public ResponseResult<User> testApiImplicitParamQuery(Integer id)
    {
        return ResponseResult.ok();
    }
    /**
     * @ApiModelProperty.example属性 有效
     */
    @ApiOperation(value = "@ApiModelBody")
    @GetMapping(path = { "/ApiModelBody" })
    public ResponseResult<CommonColumnData> testApiModelBody(@RequestBody User param)
    {
        return ResponseResult.ok();
    }
    /**
     * @ApiImplicitParams.examples属性 无效,UI无法解析
     */
    @ApiOperation(value = "@ApiImplicitParamBody")
    @GetMapping(path = { "/ApiImplicitParamBody" })
    @ApiImplicitParams({ @ApiImplicitParam(name = "param", required = true, dataType = "object", paramType = "body", examples = @Example({ @ExampleProperty(value = "{\"columnName\":\"ADDRESS\",\"searchContition\":\"北\"}", mediaType = "application/json") }), value = "{'columnName':'代码表名','searchContition':'筛选条件'}") })
    public ResponseResult<CommonColumnData> testApiImplicitParamBody(@RequestBody Map param)
    {
        return ResponseResult.ok();
    }
    /**
     * @ApiParam.examples属性 无效,UI无法解析
     */
    @ApiOperation(value = "@ApiParamBody")
    @GetMapping(path = { "/ApiParamBody" })
    public ResponseResult<CommonColumnData> testApiParam(
            @ApiParam(required = true, value = "{'columnName':'代码表名','searchContition':'筛选条件'}", examples = @Example({ @ExampleProperty(value = "{\"columnName\":\"ADDRESS\",\"searchContition\":\"北\"}", mediaType = "application/json") }))
            @RequestBody Map param)
    {
        return ResponseResult.ok();
    }

}
