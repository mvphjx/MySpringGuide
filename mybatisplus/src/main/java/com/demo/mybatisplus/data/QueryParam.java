package com.demo.mybatisplus.data;

import lombok.Data;

import java.util.List;

/**
 * @author hjx
 * @version 1.0
 * @date 2021/7/18 23:20
 */
@Data
public class QueryParam
{
    private List<String> cols;
    private List<WhereParam> whereParams;
    private int pageSize = 10;
    private int count = 3000;
    private int pageNum = 1;
}
