package com.yx.springcloud.controller;

import com.yx.springcloud.fegin.TableOneService;
import com.yx.springcloud.vo.TableVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yx start
 * @create 2020/6/11,20:25
 */
@RestController
public class TableController {

    @Resource
    private TableOneService tableOneService;

    /**
     * 为了方便测试，采用get方式
     * @param tableVO
     */
    @GetMapping("/create")
    public void create(TableVO tableVO){

        tableOneService.createTable(tableVO);
    }
}
