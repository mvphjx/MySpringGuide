package com.common.biz;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import com.common.base.exception.CustomException;
import com.common.base.result.HttpEnum;
import com.common.biz.opi.ISeckillService;
import com.common.dao.SeckillDao;
import com.common.dao.SeckillLogDao;
import com.common.data.Exposer;
import com.common.model.Seckill;
import com.common.model.SeckillLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 负责秒杀的业务逻辑实现
 *
 * @author hjx
 * @version 1.0
 * @date 2021/12/2 22:18
 */
@Service
@Slf4j
public class SeckillServiceImpl implements ISeckillService
{
    @Autowired
    private SeckillDao dao;
    @Autowired
    private SeckillLogDao seckillLogDao;
    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public long init()
    {
        if (dao.count() < 100000)
        {
            for (int i = 0; i < 10000; i++)
            {
                Seckill seckill = new Seckill();
                seckill.setName(UUID.fastUUID().toString());
                seckill.setNumber(RandomUtil.randomInt(1000));
                dao.save(seckill);
            }
        }
        return dao.count();
    }

    @Override
    public List<Seckill> getSeckillList()
    {
        Page<Seckill> all = dao.findAll(PageRequest.ofSize(10));
        return all.stream().collect(Collectors.toList());
    }

    @Override
    public Seckill getById(long seckillId)
    {
        return dao.getById(seckillId);
    }

    /* 加入一个盐值，用于混淆*/
    private final String redisKey = "Seckill";

    @Override
    public Exposer exportSeckillUrl(long seckillId)
    {
        Seckill seckill = dao.getById(seckillId);
        redisTemplate.opsForHash().putIfAbsent(redisKey, seckill.getId() + "", seckill.getNumber() + "");
        String md5 = getMd5(seckillId);
        return new Exposer(true, md5, seckillId);
    }

    /* 加入一个盐值，用于混淆*/
    private final String salt = "thisIsASaltValue";

    private String getMd5(long seckillId)
    {
        String base = seckillId + "/" + salt;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

    @Override
    public SeckillLog executeSeckill(long seckillId, String userPhone, String md5)
    {
        if (md5 == null || !md5.equals(getMd5(seckillId)))
        {
            log.error("秒杀数据被篡改");
            throw new CustomException(HttpEnum.ERROR_400.code(), "seckill data rewrite");
        }
        try
        {
            int count = Integer.parseInt(redisTemplate.opsForHash().entries(redisKey).get(seckillId + "") + "");
            if (count <= 0)
            {
                throw new CustomException(HttpEnum.ERROR_400.code(), "库存没了");
            }
            // 重复秒杀 判定
            // 减库存 ，热点商品的竞争
            redisTemplate.opsForHash().put(redisKey, seckillId + "", count-1 + "");
            // 记录购买行为
            SeckillLog seckillLog = new SeckillLog();
            seckillLog.setSeckillId(seckillId);
            seckillLog.setUserPhone(userPhone);
            seckillLogDao.save(seckillLog);
            // 更新数据库库存
            Seckill seckill = dao.getById(seckillId);
            seckill.setNumber(seckill.getNumber() - 1);
            dao.save(seckill);
        }
        catch (Exception e)
        {
            throw e;
        }

        return null;
    }
}
