package com.yx.springcloud.fegin;

import com.yx.springcloud.vo.TableVO;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author yx start
 * @create 2020/6/11,20:14
 */
public interface TableOneService {
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
    void update(Integer userId, String name);
}
