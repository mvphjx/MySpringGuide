package com.demo.mybatisplus.mapper;

import com.demo.mybatisplus.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author han
 * @since 2021-07-18
 */
@Mapper
public interface UserMapper extends BaseMapper<User>
{
    /**
     * 使用注解构造复杂的自定义语句
     *
     * <script></script>
     * <if></if>
     *
     * @param map 查询参数
     * @return
     */
//    @Select("<script>select t.*" + "from user t where 1=1" + " <if test=\"id != null\">AND t.id<= #{id} </if>"
//                    + "</script>")
    List<Map<String, Object>> query(Map<String, Object> map);
}
