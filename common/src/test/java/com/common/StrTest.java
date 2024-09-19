package com.common;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.crypto.digest.MD5;
import org.w3c.dom.Element;

import java.io.File;
import java.time.format.DateTimeFormatter;

public class StrTest
{
    public static void main(String[] args)
    {
        open("D:/pageoffice");
        System.out.println("\n\n\n");
        open("file:///pageoffice");
        System.out.println("\n\n\n");
        open("file:/pageoffice");


    }

    public static void open(String path)
    {
        System.out.println("path:" + path+"-"+FileUtil.normalize(path));
        //打开Word文档
        String dateStr = LocalDateTimeUtil.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String fileName = "a.docx";
        String filePath = path + File.separator + dateStr + File.separator + fileName;
        filePath = filePath.replace("/", "/").replace("\\", "/");
        System.out.println(filePath);
        webOpen(filePath);
    }

    public static void webOpen(String var1)
    {

        int var4;
        if ((var4 = var1.indexOf(":\\")) < 0)
        {
            var4 = var1.indexOf("file://");
        }

        boolean var5;
        String var7;
        if (var4 >= 0)
        {
            var5 = false;
            String var6 = var1;
            if (var1.indexOf("file://") >= 0)
            {
                var6 = var1.substring(7);
                System.out.println("var6:"+var6);
            }
        }
        else
        {
            var5 = true;
        }
        if (var5)
        {
            System.out.println("var5:"+var5);
        }
        else
        {
            var7 = var1;
            if (var1.indexOf("file://") >= 0)
            {
                var7 = var1.substring(7);
                System.out.println("var7:"+var7);
            }

            int var8 = var7.lastIndexOf("/");
            var4 = var7.lastIndexOf("\\");
            if (var8 < var4)
            {
                var8 = var4;
            }

            String var9 = var7.substring(var8 + 1);
            System.out.println("var9:"+var9);
            var1 = "file=" + "&contenttype=application/octet-stream&filename=".replace("+", "-A").replace("/", "-S")
                    .replace("=", "-X");
            System.out.println(var1);
        }
    }
}
