package com.common.dao;

/**
 * 秒杀商品
 * @author hjx
 * @version 1.0
 * @date 2021/12/2 22:08
 */

import com.common.model.Seckill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeckillDao extends JpaRepository<Seckill, Long>
{

}
