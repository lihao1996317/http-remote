package com.example.exp.utils;

import com.alibaba.fastjson.JSONObject;
import com.example.exp.vo.WallheadCoordinateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * HttpUtil
 *
 * @author xzr
 * 2020/7/14 15:17
 **/
@Slf4j
public class HttpUtil {

    /**
     * HttpGet
     *
     * @param map 参数
     * @return 返回对象
     */
    public static List<Object> httpGet(Map<Object, Object> map) {
        String url = "http://192.168.1.244:8050/DasService/DataService/zjdzfasj/basic/jkzb/jkzb";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.add("CallCode", "zjdzsj");

        HttpEntity<Object> formEntity = new HttpEntity<>(null, headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, formEntity, String.class, map);

        String body = responseEntity.getBody();
        List<WallheadCoordinateVo> list = JSONObject.parseArray(body, WallheadCoordinateVo.class);

//        List<WallheadCoordinateVo> voList = restTemplate.getForObject(url, List.class, map);
        List<Object> lists = Arrays.asList(list.toArray());
        return lists;
    }

    public static String httpTestGet1() {
        String url = "http//localhost:8009/test007";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<Object> formEntity = new HttpEntity<>(null, headers);

//        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, formEntity, String.class);
//        String body = responseEntity.getBody();
        RestTemplate restTemplate = new RestTemplate();
        String object = restTemplate.getForObject(url, String.class);
        log.debug(object);

        return object;
    }

    public static String httpPost(String objToString,String url){
        //设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.add("CallCode", "zjdzsj");
        headers.add("ActionType", "save");

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Object> Entity = new HttpEntity<>(objToString, headers);
        String result = restTemplate.postForObject(url, Entity, String.class);
        return result;

    }
}

