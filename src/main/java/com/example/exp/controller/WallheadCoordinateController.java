package com.example.exp.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.exp.bean.WellNode;
import com.example.exp.service.WallheadCoordinateService;
import com.example.exp.vo.WallheadCoordinateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

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
    public Map<String, String> saveWallheadCoodintaeVo(@RequestBody List<WallheadCoordinateVo> vo) {
//        //组装共有数据
//        List<JSONObject> tyList = new ArrayList<>();
//        List<JSONObject> csList = new ArrayList<>();
        //设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.add("CallCode", "zjdzsj");
        headers.add("ActionType", "save");
        String url = "http://192.168.1.244:8050/DasService/DataService/ceshi/ceshi/WELL_NODE";
        String tyObj = null;
        String csObj = null;
        for (WallheadCoordinateVo singleVo : vo) {
            WellNode tyWellNode = new WellNode();
            WellNode csWellNode = new WellNode();
            //插入共有数据
            //插入坐标类型id，经纬度，备注,井号，原始序号，坐标系id
            tyWellNode.setUwi(singleVo.getJh());
            tyWellNode.setOriginalObsNo(singleVo.getXh());
            tyWellNode.setLocationType(singleVo.getZblxid());
            tyWellNode.setLatitude(singleVo.getWd());
            tyWellNode.setLongtude(singleVo.getJd());
            tyWellNode.setRemark(singleVo.getBz());
//            wellNode.setEffectiveDate(new Date());
//            Calendar calendar = Calendar.getInstance();
//            calendar.set(9999, 12, 31);
//            wellNode.setExpiryDate(calendar.getTime());
//            wellNode.setActiveInd("Y");
//            wellNode.setRowCreatedDate(new Date());

            //录入统一坐标信息
            tyWellNode.setCoordSystemId(singleVo.getTyzbxid());
            tyWellNode.setCoordAquisitionId(singleVo.getTyzbcjid());
            tyWellNode.setCoordSystemId(singleVo.getTyjdid());
            tyWellNode.setNodePosition("TY");
            JSONObject tyJson = (JSONObject) JSONObject.toJSON(tyWellNode);
            //执行
            HttpEntity<Object> tyEntity = new HttpEntity<>(tyJson.toString(), headers);
            tyObj = restTemplate.postForObject(url, tyEntity, String.class);

            //录入初始坐标信息
            csWellNode.setUwi(singleVo.getJh());
            csWellNode.setOriginalObsNo(singleVo.getXh());
            csWellNode.setLocationType(singleVo.getZblxid());
            csWellNode.setLatitude(singleVo.getWd());
            csWellNode.setLongtude(singleVo.getJd());
            csWellNode.setRemark(singleVo.getBz());

            //录入初始坐标信息
            csWellNode.setCoordSystemId(singleVo.getTyzbxid());
            csWellNode.setCoordAquisitionId(singleVo.getTyzbcjid());
            csWellNode.setCoordSystemId(singleVo.getTyjdid());
            csWellNode.setNodePosition("CS");
            JSONObject csJson = (JSONObject) JSONObject.toJSON(tyWellNode);
            //执行
            HttpEntity<Object> csEntity = new HttpEntity<>(tyJson.toString(), headers);
            csObj = restTemplate.postForObject(url, csEntity, String.class);
        }
        //执行

        log.debug("通用信息:" + tyObj + "/n" + "初始信息：" + csObj);
        HashMap<String, String> map = new HashMap<>();
        map.put("通用信息", tyObj);
        map.put("初始信息", csObj);
        return map;
    }
}
