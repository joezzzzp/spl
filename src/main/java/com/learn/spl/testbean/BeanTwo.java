package com.learn.spl.testbean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author created by zzz at 2019/10/28 10:17
 */

public class BeanTwo {

    private BeanOne beanOne;

    @Autowired
    public BeanTwo(BeanOne beanOne) {
        this.beanOne = beanOne;
    }

    public BeanOne getBeanOne() {
        return beanOne;
    }
}
