package com.yx.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**自定义规则不能在@mapperScan 得到扫描
 * 自定义轮序规则
 * @author yx start
 * @create 2020/4/8,11:53
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
     // 返回随机
        return new RandomRule();
    }

}
