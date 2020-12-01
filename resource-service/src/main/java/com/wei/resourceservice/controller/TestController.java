package com.wei.resourceservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author skye
 * @version 1.0
 * @description:
 * @date 2020/11/30 14:05
 */
@RestController
public class TestController {

    @RequestMapping("/user/me")
    public Principal user(Principal principal) {
        return principal;
    }

    @RequestMapping("/user/test1")
    public String test() {
        return "test1";
    }

    @RequestMapping("/user/test2")
    public String test2() {
        return "test2";
    }
    @RequestMapping("/test")
    public String test(Principal principal) {
        return "test";
    }
}
