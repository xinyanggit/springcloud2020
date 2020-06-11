package com.yx.springcloud.dao;

import com.yx.springcloud.vo.TableVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yx start
 * @create 2020/6/11,19:58
 */
@Mapper
public interface TableDao {

    /**
     * 创建用户
     *
     * @param tableVO
     */
    void createTable(TableVO tableVO);

    /**
     * 修改数据
     *
     * @param userId
     */
    void update(@Param("id") Integer userId, @Param("name") String name);
    
}
