package com.yx.springcloud.service;

import com.yx.springcloud.dao.TableDao;
import com.yx.springcloud.fegin.TableOneService;
import com.yx.springcloud.fegin.TableTwoService;
import com.yx.springcloud.fegin.TableThreeService;
import com.yx.springcloud.vo.TableVO;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author yx start
 * @create 2020/6/11,20:09
 */
@Service("tableOneService")
@Slf4j
public class TableServiceImpl implements TableOneService {
    @Resource
    private TableDao tableDao;

    /**
     * 其他服务调用
     */
    @Resource
    private TableTwoService tableTwoService;

    /**
     * 其他服务调用
     */
    @Resource
    private TableThreeService tableThreeService;


   // @Transactional(rollbackFor = Exception.class)
    @GlobalTransactional(name="test-yx",rollbackFor = Exception.class)
    @Override
    public void createTable(TableVO tableVO) {
        log.info("创建test1数据==start");
        tableDao.createTable(tableVO);
        log.info("创建test1数据==end");
        log.info("创建test2数据==start");
        tableTwoService.createTable(tableVO);
        log.info("创建test2数据==end");
        log.info("创建test3数据==start");
        tableThreeService.createTable(tableVO);
        log.info("创建test3数据==end");
    }

    @Override
    public void update(Integer userId, String name) {
        log.info("更新数据test1====>");
        tableDao.update(userId, name);
    }

}
