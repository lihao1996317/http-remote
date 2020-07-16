package com.example.exp.utils;

import com.alibaba.fastjson.JSONObject;
import com.example.exp.vo.ResultVo;
import com.example.exp.vo.TestVo;
import com.example.exp.vo.WallheadCoordinateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * HttpUtil
 *
 * @author xzr
 * 2020/7/14 15:17
 **/
@Slf4j
public class HttpUtil {

    @Autowired
    private static RestTemplate restTemplate;

    /**
     * 发送post请求
     *
     * @param url    地址
     * @param params 参数
     * @return 返回对象
     */
    public static ResultVo sendPostRequest(String url, MultiValueMap<String, String> params) {
        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpMethod method = HttpMethod.POST;
        // 以表单的方式提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //将请求头部和参数合成一个请求
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        //执行HTTP请求，将返回的结构使用ResultVO类格式化
        ResponseEntity<ResultVo> response = client.exchange(url, method, requestEntity, ResultVo.class);
        return response.getBody();
    }

    public static String save(TestVo testVo) {
        JSONObject jsonObj = (JSONObject) JSONObject.toJSON(testVo);
        List<JSONObject> list = new ArrayList();
        list.add(jsonObj);

        log.debug(list.toString());

//        RestTemplate template = new RestTemplate();
        //设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.add("CallCode", "zjdzsj");
        headers.add("ActionType", "save");
        headers.add("Token", "6C5D0D5040DE9D973F4B038878167B17F94A0852F1A8ADF5B9ACA396D06663F7DE0C01EB7278AAD2A61467FCA3B08E2CA2AE49A88D162D10F9D9C2FC44476FD0F22FB81B7D2196F0A2D3AF842F85E95A7B7CA84CEC62509DF23F558B7F6DDE3AF3FD606B2CBE2F3B9DB519F9A1134800FADA8CCBCBCC3797B0ADCD60966A552EA28915AE4A4BC81E");

        log.debug("请求头信息" + headers);

        //请求体
        HttpEntity<Object> formEntity = new HttpEntity<>(list.toString(), headers);

        log.debug("请求体信息：" + formEntity);

        //请求地址
        String url = "http://192.168.1.244:8050/DasService/DataService/zjdzfasj/basic/dcgk/dcgk";
//        String url = "http://localhost:8009/test";
        String object = restTemplate.postForObject(url, formEntity, String.class);
        log.debug(object);
        return object;
    }

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
        String object = restTemplate.getForObject(url, String.class);
        log.debug(object);

        return object;
    }
}
