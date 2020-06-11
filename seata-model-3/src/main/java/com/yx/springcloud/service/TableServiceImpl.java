package com.yx.springcloud.service;

import com.yx.springcloud.dao.TableDao;
import com.yx.springcloud.fegin.TableThreeService;
import com.yx.springcloud.payment.entity.CommonResult;
import com.yx.springcloud.vo.TableVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yx start
 * @create 2020/6/11,20:09
 */
@Service("tableThreeService")
@Slf4j
public class TableServiceImpl implements TableThreeService {
    @Resource
    private TableDao tableDao;


    @Override
    public CommonResult createTable(TableVO tableVO) {
        log.info("model3==创建test3数据==start");
        tableDao.createTable(tableVO);
        return new CommonResult(200, "success");
    }

    @Override
    public void update(Integer userId, String name) {
        log.info("更新数据====>test1");
        tableDao.update(userId, name);
    }

}
