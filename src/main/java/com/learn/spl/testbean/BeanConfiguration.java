package com.learn.spl.testbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author created by zzz at 2019/10/28 10:17
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public BeanOne beanOne() {
        return new BeanOne();
    }

    @Bean
    public BeanTwo beanTwo() {
        return new BeanTwo(beanOne());
    }
}
