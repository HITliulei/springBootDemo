package com.ll.redis.controller;

import com.ll.redis.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/7/6
 */

@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/test1")
    public String testString()  {
        stringRedisTemplate.opsForValue().set("test1", "test1_value");
        String name = stringRedisTemplate.opsForValue().get("name");
        return "the value of key 'name' is : " + name ;
    }

    @GetMapping("/testO")
    public String testObject(){
        ValueOperations<String, User> valueOperations =  redisTemplate.opsForValue();
        User user = new User("user1","password1");
        valueOperations.set("user1", user);
        User user2 = new User("user2","password2");
        valueOperations.set("user2",user2, 10, TimeUnit.SECONDS);
        try {
            Thread.sleep(11000);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (valueOperations.get("user2") == null){
            return valueOperations.get("user1").toString();
        }
        return valueOperations.get("user2").toString();
    }
}
