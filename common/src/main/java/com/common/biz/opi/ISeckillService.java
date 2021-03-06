package com.common.biz.opi;

import com.common.data.Exposer;
import com.common.model.Seckill;
import com.common.model.SeckillLog;

import java.util.List;

/**
 * 秒杀相关业务逻辑
 */
public interface ISeckillService
{

    /**
     * 初始化秒杀商品
     *
     * @return 初始化的数量
     */
    long mockData();

    /**
     * 查询全部的秒杀记录.
     *
     * @return 数据库中所有的秒杀记录
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     *
     * @param seckillId 秒杀记录的ID
     * @return 根据ID查询出来的记录信息
     */
    Seckill getById(long seckillId);

    /**
     * 在秒杀开启时输出秒杀接口的地址，否则输出系统时间跟秒杀地址
     *
     * @param seckillId 秒杀商品Id
     * @return 根据对应的状态返回对应的状态实体
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作，有可能是失败的，失败我们就抛出异常
     *
     * @param seckillId 秒杀的商品ID
     * @param userPhone 手机号码
     * @param md5       md5加密值
     * @return 秒杀结果
     */
    SeckillLog executeSeckill(long seckillId, String userPhone, String md5);
}









