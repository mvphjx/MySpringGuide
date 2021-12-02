package com.common.data;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 暴露秒杀地址接口
 */
@Data
public class Exposer
{
    @ApiModelProperty(value = "是否开启秒杀")
    private boolean exposed;
    @ApiModelProperty(value = "对秒杀地址进行加密措施")
    private String md5;
    @ApiModelProperty(value = "id为seckillId的商品秒杀地址")
    private long seckillId;
    @ApiModelProperty(value = "系统当前的时间")
    private LocalDateTime now;
    @ApiModelProperty(value = "秒杀开启的时间")
    private LocalDateTime start;
    @ApiModelProperty(value = "秒杀结束的时间")
    private LocalDateTime end;

    public Exposer()
    {
    }

    public Exposer(boolean exposed, String md5, long seckillId)
    {
        this.exposed = exposed;
        this.md5 = md5;
        this.seckillId = seckillId;
    }
}
