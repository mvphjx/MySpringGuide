package com.common.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 商品秒杀对象
 */
@Entity
@Data
public class Seckill implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ApiModelProperty(value = "秒杀商品名字")
    private String name;
    @ApiModelProperty(value = "库存")
    private int number;
    @ApiModelProperty(value = "开始秒杀的时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime = LocalDateTime.now();
    @ApiModelProperty(value = "结束秒杀的时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime = LocalDateTime.now();
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //@Column(name = "create_time")
    private LocalDateTime createTime = LocalDateTime.now();

    public Seckill()
    {
    }

}
