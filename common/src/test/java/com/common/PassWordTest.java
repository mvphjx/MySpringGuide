package com.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author hjx
 * @version 1.0
 * @date 2021/7/15 23:55
 */
public class PassWordTest
{
    public static void main(String[] args)
    {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("1");
        System.out.println(encode);
    }
}
