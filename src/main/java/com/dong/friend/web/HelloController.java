package com.dong.friend.web;

import groovy.util.logging.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dong.friend.bean.Hello;

/**
 * com.dong.friend.web
 * Created by mimiczo on 2016.03.03
 */
@Slf4j
@RestController
@RequestMapping("/redis")
public class HelloController {

    @Autowired
    RedisTemplate<String, Hello> redisTemplate;

    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    public Hello get(@PathVariable("key") String key) {
        Hello hello = redisTemplate.opsForValue().get("hello:"+key);
        return hello;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED) @RequestBody 
    public void save(Hello hello) {
        redisTemplate.opsForValue().set("hello:"+hello.getName(), hello);
    }
    
    
    @RequestMapping(value = "/")
    public ModelAndView redisIndex(@ModelAttribute Hello hello){
    	return new ModelAndView("redis/form", "hello", hello);
    }
    
}