package com.learn.spl.testbean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @author created by zzz at 2019/10/28 10:21
 */
@RestController
@RequestMapping("/beans")
public class BeanController {

    private static final Logger logger = LoggerFactory.getLogger(BeanController.class);

    private BeanOne beanOne;

    private BeanTwo beanTwo;

    @Autowired
    public BeanController(BeanOne beanOne, BeanTwo beanTwo) {
        this.beanOne = beanOne;
        this.beanTwo = beanTwo;
    }

    @PostConstruct
    public void test() {
        logger.info("{}", beanOne);
        logger.info("{}", beanTwo);
        logger.info("{}", beanTwo.getBeanOne());
    }
}
