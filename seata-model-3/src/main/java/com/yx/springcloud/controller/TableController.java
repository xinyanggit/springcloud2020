package com.yx.springcloud.controller;

import com.yx.springcloud.fegin.TableThreeService;
import com.yx.springcloud.payment.entity.CommonResult;
import com.yx.springcloud.vo.TableVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yx start
 * @create 2020/6/11,23:18
 */
@RestController
public class TableController {
    @Resource
    private TableThreeService tableThreeService;

    /**
     * 创建用户
     *
     * @param tableVO
     */
    @PostMapping("/create")
    CommonResult createTable(@RequestBody  TableVO tableVO) {
        return tableThreeService.createTable(tableVO);
    }

    /**
     * 修改数据
     *
     * @param userId
     */
    @GetMapping("/update")
    void update(Integer userId, String name){

    }
}
