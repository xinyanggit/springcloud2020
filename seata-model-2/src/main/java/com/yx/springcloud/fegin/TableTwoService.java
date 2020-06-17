package com.yx.springcloud.fegin;

import com.yx.springcloud.payment.entity.CommonResult;
import com.yx.springcloud.vo.TableVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yx start
 * @create 2020/6/11,20:14
 */
public interface TableTwoService {
    /**
     * 创建用户
     *
     * @param tableVO
     */
    @GetMapping("/create")
    CommonResult createTable(TableVO tableVO);

    /**
     * 修改数据
     *
     * @param userId
     */
    @GetMapping("/update")
    void update(Integer userId, String name);
}
