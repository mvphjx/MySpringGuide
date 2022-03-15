package com.common.base.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 统一日志打印工具类
 */
public interface AllLoggers
{

    /**
     * 应用日志
     */
    Logger APPLICATION = LoggerFactory.getLogger("APPLICATION");

    /**
     * 异常日志
     */
    Logger EXCEPTION = LoggerFactory.getLogger("EXCEPTION");

    /**
     * 业务日志
     */
    Logger BIZ = LoggerFactory.getLogger("BIZ");

    /**
     * hsf日志
     */
    Logger HSF = LoggerFactory.getLogger("HSF");

    /**
     * 入口日志
     */
    Logger MTOP = LoggerFactory.getLogger("MTOP");

}
