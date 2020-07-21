package com.example.exp.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.exp.bean.CsCoordAcauisition;
import com.example.exp.bean.WellNode;
import com.example.exp.constant.UrlConstant;
import com.example.exp.utils.HttpUtil;
import com.example.exp.vo.WallheadCoordinateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * WallheadCoordinateController
 *
 * @author xzr
 * 2020/7/15 11:06
 * 井口坐标前端控制器
 **/
@CrossOrigin
@Slf4j
@RestController
public class WallheadCoordinateController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getWallheadCoordinateDeatil")
    public Object getWallheadCoordinateDeatil(@RequestParam(required = false) String jh,
                                              @RequestParam(required = false) String dq) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("jh", jh);
        map.put("dp", dq);
        String url = "http://192.168.1.244:8050/DasService/DataService/ceshi/ceshi/WELL_NODE";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.add("CallCode", "zjdzsj");
        HttpEntity<Object> formEntity = new HttpEntity<>(null, headers);

        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, formEntity, String.class, map);
        String body = exchange.getBody();
        //转json
        JSONObject jsonObject = JSONObject.parseObject(body);
        log.debug(body);

        //返回给前端的vo对象
        WallheadCoordinateVo vo = new WallheadCoordinateVo();
        //查询well_node,
        return body;
    }

    @PostMapping("/saveWallheadCoodintaeVo")
    public Map<String, String> saveWallheadCoodintaeVo(@RequestBody List<WallheadCoordinateVo> vo) {
        List<JSONObject> tyList = new ArrayList<>();
        List<JSONObject> csList = new ArrayList<>();
        List<JSONObject> csacquisitionList = new ArrayList<>();
        List<JSONObject> tyacquisitionList = new ArrayList<>();

        JSONObject tyJson;
        JSONObject csJson;
        JSONObject csAcauisitionJson;
        JSONObject tyAcauisitionJson;
        for (WallheadCoordinateVo singleVo : vo) {
            WellNode tyWellNode = new WellNode();
            WellNode csWellNode = new WellNode();
            CsCoordAcauisition csAcauisition = new CsCoordAcauisition();
            CsCoordAcauisition tyAcauisition = new CsCoordAcauisition();
            //插入共有数据
            //插入坐标类型id，经纬度，备注,井号，原始序号，坐标系id
            tyWellNode.setUwi(singleVo.getJh());
            tyWellNode.setOriginal_obs_no(singleVo.getXh());
            tyWellNode.setLocation_type(singleVo.getZblxid());
            tyWellNode.setLatitude(singleVo.getWd());
            tyWellNode.setLongitude(singleVo.getJd());
            tyWellNode.setRemark(singleVo.getBz());
            tyWellNode.setRow_changed_by(singleVo.getV_login());
            //录入统一坐标信息
            tyWellNode.setCoord_system_id(singleVo.getTyzbxid());
            tyWellNode.setCoord_acquisition_id(singleVo.getTyzbcjid());
            tyWellNode.setNode_id(singleVo.getTyjdid());
            tyWellNode.setNode_position("TY");
            tyWellNode.setRowState(singleVo.getRowState());
            tyJson = (JSONObject) JSONObject.toJSON(tyWellNode);
            tyList.add(tyJson);

            //录入共有坐标信息
            csWellNode.setUwi(singleVo.getJh());
            csWellNode.setOriginal_obs_no(singleVo.getXh());
            csWellNode.setLocation_type(singleVo.getZblxid());
            csWellNode.setLatitude(singleVo.getWd());
            csWellNode.setLongitude(singleVo.getJd());
            csWellNode.setRemark(singleVo.getBz());
            csWellNode.setRow_changed_by(singleVo.getV_login());

            //录入初始坐标信息
            csWellNode.setCoord_system_id(singleVo.getCszbxid());
            csWellNode.setCoord_acquisition_id(singleVo.getCszbcjid());
            csWellNode.setNode_id(singleVo.getCsjdid());
            csWellNode.setNode_position("CS");
            csWellNode.setRowState(singleVo.getRowState());
            csJson = (JSONObject) JSONObject.toJSON(csWellNode);
            csList.add(csJson);

            //插入初始ACQUISITION附属表信息
            csAcauisition.setAcquisition_id(singleVo.getCszbcjid());
            csAcauisition.setHorizontal_accuracy(singleVo.getCshzb());
            csAcauisition.setVertical_accuracy(singleVo.getCszzb());
            csAcauisition.setRow_created_by(singleVo.getV_login());
            csAcauisition.setRowState(singleVo.getRowState());
            csAcauisitionJson = (JSONObject) JSONObject.toJSON(csAcauisition);
            csacquisitionList.add(csAcauisitionJson);

            //插入通用
            tyAcauisition.setAcquisition_id(singleVo.getTyzbcjid());
            tyAcauisition.setHorizontal_accuracy(singleVo.getTyhzb());
            tyAcauisition.setVertical_accuracy(singleVo.getTyzzb());
            tyAcauisition.setRow_created_by(singleVo.getV_login());
            tyAcauisition.setRowState(singleVo.getRowState());
            tyAcauisitionJson = (JSONObject) JSONObject.toJSON(tyAcauisition);
            tyacquisitionList.add(tyAcauisitionJson);

        }

        //执行well_node表插入
        String tyObj = HttpUtil.httpPost(tyList.toString(), UrlConstant.WELL_NODE_URL);
        String csObj = HttpUtil.httpPost(csList.toString(), UrlConstant.WELL_NODE_URL);
        //执行CsCoordAcauisition表插入
        String tyAcauisitionObj = HttpUtil.httpPost(tyacquisitionList.toString(), UrlConstant.CS_COORD_ACQUISITION_URL);
        String csAcauisitionObj = HttpUtil.httpPost(csacquisitionList.toString(), UrlConstant.CS_COORD_ACQUISITION_URL);
        HashMap<String, String> map = new HashMap<>();
        map.put("通用信息", tyObj);
        map.put("初始信息", csObj);
        map.put("通用采购信息：", tyAcauisitionObj);
        map.put("初始采购信息：", csAcauisitionObj);
        return map;
    }

}
