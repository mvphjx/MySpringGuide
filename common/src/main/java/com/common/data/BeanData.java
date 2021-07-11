package com.common.data;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 前端展示/视图对象
 * @author hjx
 * @version 1.0
 * @date 2021/7/11 23:24
 */
@Data
public class BeanData
{
    private List<String> list = new ArrayList<>();
}
