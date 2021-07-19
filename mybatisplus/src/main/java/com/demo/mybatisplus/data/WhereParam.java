package com.demo.mybatisplus.data;

import lombok.Data;

import java.util.List;

/**
 * @author hjx
 * @version 1.0
 * @date 2021/7/18 23:21
 */
@Data
public class WhereParam
{
    private String colName;
    private String option;
    private List<String> values;
    private String valus1;
    private String valus2;
}
