package com.demo.mybatisplus;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * mp测试
 *
 * @author hjx
 * @version 1.0
 * @date 2021/7/18 18:09
 */
@SpringBootTest
public class TableSearchTest
{
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TableSearchTest.class);

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Test
    public void search()
    {
        String sql = "select * from user";
        List<Map<String, Object>> maps = excuteQuerySql(sql);
        printJson(maps);
    }

    public List<Map<String, Object>> excuteQuerySql(String sql)
    {
        log.info("执行查询sql:" + sql);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        PreparedStatement pst = null;
        SqlSession session = getSqlSession();
        ResultSet result = null;
        try
        {
            pst = session.getConnection().prepareStatement(sql);
            result = pst.executeQuery();
            ResultSetMetaData md = result.getMetaData(); //获得结果集结构信息,元数据
            int columnCount = md.getColumnCount();   //获得列数
            while (result.next())
            {
                Map<String, Object> rowData = new HashMap<String, Object>();
                for (int i = 1; i <= columnCount; i++)
                {
                    rowData.put(md.getColumnName(i), result.getObject(i));
                }
                list.add(rowData);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (pst != null)
            {
                try
                {
                    pst.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
            closeSqlSession(session);
        }
        return list;
    }

    /**
     * 获取sqlSession
     *
     * @return
     */
    public SqlSession getSqlSession()
    {
        return SqlSessionUtils
                .getSqlSession(sqlSessionTemplate.getSqlSessionFactory(), sqlSessionTemplate.getExecutorType(),
                        sqlSessionTemplate.getPersistenceExceptionTranslator());
    }

    /**
     * 关闭sqlSession
     *
     * @param session
     */
    public void closeSqlSession(SqlSession session)
    {
        SqlSessionUtils.closeSqlSession(session, sqlSessionTemplate.getSqlSessionFactory());
    }

    private void printJson(Object obj)
    {
        JSON json = JSONUtil.parse(obj);
        String str = JSONUtil.toJsonStr(json, 2);
        log.info(str);
    }
}
