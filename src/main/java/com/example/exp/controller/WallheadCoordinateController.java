package com.example.exp.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.exp.bean.WellNode;
import com.example.exp.service.WallheadCoordinateService;
import com.example.exp.vo.WallheadCoordinateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
        List<JSONObject> tyList = new ArrayList<>();
        List<JSONObject> csList = new ArrayList<>();
        //设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.add("CallCode", "zjdzsj");
        headers.add("ActionType", "save");
        String url = "http://192.168.1.244:8050/DasService/DataService/ceshi/ceshi/WELL_NODE";
        String tyObj;
        String csObj;
        JSONObject tyJson;
        JSONObject csJson;
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
            tyWellNode.setRowChangedBy(singleVo.getV_login());

            //录入统一坐标信息
            tyWellNode.setCoordSystemId(singleVo.getTyzbxid());
            tyWellNode.setCoordAquisitionId(singleVo.getTyzbcjid());
            tyWellNode.setNode_id(singleVo.getTyjdid());
            tyWellNode.setNodePosition("TY");
            tyJson = (JSONObject) JSONObject.toJSON(tyWellNode);
            tyList.add(tyJson);

            //录入共有坐标信息
            csWellNode.setUwi(singleVo.getJh());
            csWellNode.setOriginalObsNo(singleVo.getXh());
            csWellNode.setLocationType(singleVo.getZblxid());
            csWellNode.setLatitude(singleVo.getWd());
            csWellNode.setLongtude(singleVo.getJd());
            csWellNode.setRemark(singleVo.getBz());
            csWellNode.setRowChangedBy(singleVo.getV_login());

            //录入初始坐标信息
            csWellNode.setCoordSystemId(singleVo.getCszbxid());
            csWellNode.setCoordAquisitionId(singleVo.getCszbcjid());
            csWellNode.setNode_id(singleVo.getCsjdid());
            csWellNode.setNodePosition("CS");
            csJson = (JSONObject) JSONObject.toJSON(csWellNode);
            csList.add(csJson);

        }
        //执行
        HttpEntity<Object> tyEntity = new HttpEntity<>(tyList.toString(), headers);
        tyObj = restTemplate.postForObject(url, tyEntity, String.class);
        HttpEntity<Object> csEntity = new HttpEntity<>(csList.toString(), headers);
        csObj = restTemplate.postForObject(url, csEntity, String.class);
        log.debug("通用信息:" + tyObj + "/n" + "初始信息：" + csObj);
        HashMap<String, String> map = new HashMap<>();
        map.put("通用信息", tyObj);
        map.put("初始信息", csObj);
        return map;
    }
}
