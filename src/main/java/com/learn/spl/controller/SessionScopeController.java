package com.learn.spl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author created by zzz at 2019/10/23 17:00
 */
@SessionScope
@RestController
@RequestMapping("/session")
public class SessionScopeController {

    private Date date = new Date();

    @RequestMapping("/check")
    public String check() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date) + "\n" + this.toString();
    }
}
