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
public class SeckillLog implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long seckillId;
    @ApiModelProperty(value = "执行秒杀结果的状态")
    private int state;
    @ApiModelProperty(value = "状态的明文标示")
    private String msg;
    @ApiModelProperty(value = "用户的手机号码")
    private String userPhone;
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime = LocalDateTime.now();

}
