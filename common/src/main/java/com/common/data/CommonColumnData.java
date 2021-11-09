package com.common.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 表格数据，一个单元格
 */
@ApiModel
public class CommonColumnData
{
    @ApiModelProperty(value = "列名")
    public String name;
    @ApiModelProperty(value = "存储值")
    public String value;
    @ApiModelProperty(value = "字典翻译值")
    public String text;
}
