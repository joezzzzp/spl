package com.learn.spl.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author created by zzz at 2019/10/23 16:06
 */

@RestController
@RequestMapping("/singleton")
public class SingletonController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private ProtoTypeController protoTypeController;

    private Date date = new Date();

    @Autowired
    public void setProtoTypeController(ProtoTypeController protoTypeController) {
        this.protoTypeController = protoTypeController;
    }

    @RequestMapping("/check")
    public String check() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date) + "\n" + this.toString();
    }

    @RequestMapping("/checkPrototypeDependence")
    public String checkPrototypeDependence() {
        return protoTypeController.check();
    }

    @RequestMapping("/checkNewPrototypeDependence")
    public String checkNewPrototypeDependence() {
        return applicationContext.getBean(ProtoTypeController.class).check();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
