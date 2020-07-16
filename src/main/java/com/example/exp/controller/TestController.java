package com.example.exp.controller;

import com.example.exp.service.TestService;
import com.example.exp.service.WallheadCoordinateService;
import com.example.exp.utils.HttpUtil;
import com.example.exp.vo.TestVo;
import com.sun.net.httpserver.Headers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * TestController
 *
 * @author xzr
 * 2020/7/14 14:53
 **/
@Slf4j
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("save")
    public void save(@RequestBody TestVo testVo) {
        String save = HttpUtil.save(testVo);
        log.debug(save);
        System.out.print(save);
    }

    @PostMapping("test")
    public String test() {
        log.debug("123456");
        System.out.print("123456");
        return "123455";
    }

    /**
     * 调用接口
     * @return
     */
    @GetMapping("test1")
    public String test1() {
        String url = "http://localhost:8009/xzrtest1";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> entity = new HttpEntity<>(null,httpHeaders);

        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        String body = exchange.getBody();
        return body;
    }

    /**
     * 服务接口
     * @return
     */
    @GetMapping("xzrtest1")
    public String xzrtest1() {
        return "12313211231231231";
    }

}
