package com.learn.spl.controller;

import com.learn.spl.NeedLog;
import com.learn.spl.entity.ResponseResult;
import com.learn.spl.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * @author created by zzz at 2019/10/29 10:56
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @NeedLog
    @PostMapping("/user")
    public ResponseResult<User> testUser(@RequestParam String id, @RequestBody User user) {
        if (new Random().nextInt(2) == 0) {
            throw new RuntimeException("随机错误");
        }
        user.setName(user.getName() + id);
        return ResponseResult.success(user);
    }
}
