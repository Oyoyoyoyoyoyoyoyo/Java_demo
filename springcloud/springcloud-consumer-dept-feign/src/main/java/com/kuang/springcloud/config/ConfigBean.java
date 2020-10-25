package com.kuang.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Author:zhanggang
 * Date:2020/10/25
 * Decription:<描述>
 *
 * @author oyoyoyoyoyoyo
 */
@Configuration
public class ConfigBean {
    /**
     * 注册restTemplate
     *
     * @return
     * @LoadBalanced
     *      ribbon注解，配置负载均衡
     *      默认为RoundRobinRule轮询
     *      RandomRule  随机
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    // /**
    //  * ribbon负载均衡 随机模式
    //  * @return
    //  */
    // @Bean
    // public IRule myRule(){
    //     return new RandomRule();
    // }
}
