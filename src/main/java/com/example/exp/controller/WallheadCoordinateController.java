package com.example.exp.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.exp.service.WallheadCoordinateService;
import com.example.exp.utils.HttpUtil;
import com.example.exp.vo.WallheadCoordinateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * WallheadCoordinateController
 *
 * @author xzr
 * 2020/7/15 11:06
 * 井口坐标前端控制器
 **/
@Slf4j
@RestController
public class WallheadCoordinateController {
    @Autowired
    private WallheadCoordinateService wallheadCoordinateService;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getWallheadCoordinateDeatil")
    public Object getWallheadCoordinateDeatil(@RequestParam(required = false) String jh,
                                              @RequestParam(required = false) String dp) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("jh", jh);
        map.put("dp", dp);
        String url = "http://192.168.1.244:8050/DasService/DataService/zjdzfasj/basic/jkzb/jkzb";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.add("CallCode", "zjdzsj");

        HttpEntity<Object> formEntity = new HttpEntity<>(null, headers);

        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, formEntity, String.class, map);
        String body = exchange.getBody();
        log.debug(body);
        return body;
    }

    @PostMapping("/saveWallheadCoodintaeVo")
    public void saveWallheadCoodintaeVo(@RequestBody List<WallheadCoordinateVo> vo) {

    }
}
