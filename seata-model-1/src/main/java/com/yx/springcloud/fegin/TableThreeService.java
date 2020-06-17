package com.yx.springcloud.fegin;

import com.yx.springcloud.vo.TableVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author yx start
 * @create 2020/6/11,20:14
 */
@FeignClient(value = "seata-model-3")
public interface TableThreeService {
    /**
     * 创建用户
     *
     * @param tableVO
     */
    @PostMapping("/create")
    void createTable( @RequestBody  TableVO tableVO);

    /**
     * 修改数据
     *
     * @param userId
     */
/*    @GetMapping("/update")
    void update(Integer userId, String name);*/
}
