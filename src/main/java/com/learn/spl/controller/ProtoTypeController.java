package com.learn.spl.controller;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author created by zzz at 2019/10/23 16:01
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("/proto")
public class ProtoTypeController {

    private Date date = new Date();

    @RequestMapping("/check")
    public String check() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date) + "\n" + this.toString();
    }
}
