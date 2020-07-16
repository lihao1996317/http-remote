package com.example.exp.service.impl;

import com.example.exp.service.TestService;
import com.example.exp.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * TestServiceImpl
 *
 * @author xzr
 * 2020/7/15 15:55
 **/
@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @Override
    public String testGet() {
        return HttpUtil.httpTestGet1();
    }
}
