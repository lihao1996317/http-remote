package com.example.exp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestCusmerController
 *
 * @author xzr
 * 2020/7/15 17:05
 **/
@Slf4j
@RestController
public class TestCusmerController {

    @GetMapping("test007")
    public String test007(){
        return "123321";
    }
}
