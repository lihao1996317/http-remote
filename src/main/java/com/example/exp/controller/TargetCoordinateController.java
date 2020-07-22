package com.example.exp.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.exp.bean.CsCoordAcauisition;
import com.example.exp.bean.WellDirSrvy;
import com.example.exp.bean.WellNode;
import com.example.exp.constant.UrlConstant;
import com.example.exp.utils.HttpUtil;
import com.example.exp.vo.TargetCoordinateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李昊
 * @Title:  靶点坐标前端控制器
 * @Package
 * @Description: 给靶点坐标前端页面提供保存接口
 * @date 2020/7/22 8:05
 */
@RestController
@Slf4j
@CrossOrigin
public class TargetCoordinateController {

    /**
    　　* @Description: 保存前端靶点坐标表格录入数据
    　　* @param  TargetCoordinateVoList 前端录入数据集合
    　　* @return 请求服务返回值
    　　* @author 李昊
    　　* @date 2020/7/22 8:51
    　　*/
    @PostMapping("/saveTargetCoordinateVo")
    public Map<String,String> saveTargetCoordinateVo(@RequestBody List<TargetCoordinateVo> voList){
        // 统一坐标系
        List<JSONObject> tyList = new ArrayList<>();
        // 初始坐标系
        List<JSONObject> csList = new ArrayList<>();
        // 统一坐标集
        List<JSONObject> tyacquisitionList = new ArrayList<>();
        // 初始坐标集
        List<JSONObject> csacquisitionList = new ArrayList<>();
        // 井斜测量
        List<JSONObject> wellDirSrvyList = new ArrayList<>();

        JSONObject tyJson;
        JSONObject csJson;
        JSONObject csAcauisitionJson;
        JSONObject tyAcauisitionJson;
        JSONObject wellDirSrvyJson;

        for (TargetCoordinateVo vo : voList) {
            // 统一
            WellNode tyWellNode = new WellNode();
            // 初始
            WellNode csWellNode = new WellNode();
            // 统一坐标集
            CsCoordAcauisition tyAcauisition = new CsCoordAcauisition();
            // 初始坐标集
            CsCoordAcauisition csAcauisition = new CsCoordAcauisition();
            // 井斜测量
            WellDirSrvy wellDirSrvy = new WellDirSrvy();

            // 录入well_node表中共有数据(节点位置、井号、纬度、位置质量、位置类型、经度、原始序号、备注、录入人)
            tyWellNode.setNode_position("TY"); //TY
            tyWellNode.setSource("BDZB");
            tyWellNode.setUwi(vo.getUwi());
            tyWellNode.setLatitude(vo.getWd());
            tyWellNode.setLocation_quality(vo.getBdmc());
            tyWellNode.setLocation_type(vo.getBdlxdm());
            tyWellNode.setLongitude(vo.getJd());
            tyWellNode.setOriginal_obs_no(vo.getBdh());
            tyWellNode.setRemark(vo.getBz());
            tyWellNode.setRow_created_by(vo.getV_login());
            //录入统一坐标信息
            tyWellNode.setCoord_system_id(vo.getTyzbxid());
            tyWellNode.setCoord_acquisition_id(vo.getTyzbcjid());
            tyWellNode.setNode_id(vo.getTyjdid());
            tyWellNode.setRowState(vo.getRowState());
            tyJson = (JSONObject) JSONObject.toJSON(tyWellNode);
            tyList.add(tyJson);

            // 录入well_node表中共有数据
            csWellNode.setNode_position("CS"); //CS
            csWellNode.setSource("BDZB");
            csWellNode.setUwi(vo.getUwi());
            csWellNode.setLatitude(vo.getWd());
            csWellNode.setLocation_quality(vo.getBdmc());
            csWellNode.setLocation_type(vo.getBdlxdm());
            csWellNode.setLongitude(vo.getJd());
            csWellNode.setOriginal_obs_no(vo.getBdh());
            csWellNode.setRemark(vo.getBz());
            csWellNode.setRow_created_by(vo.getV_login());
            //录入初始坐标信息
            csWellNode.setCoord_system_id(vo.getCszbxid());
            csWellNode.setCoord_acquisition_id(vo.getCszbcjid());
            csWellNode.setNode_id(vo.getCsjdid());
            csWellNode.setRowState(vo.getRowState());
            csJson = (JSONObject) JSONObject.toJSON(csWellNode);
            csList.add(csJson);

            //录入统一坐标集关联数据
            tyAcauisition.setAcquisition_id(vo.getTyzbcjid()); //统一坐标采集id
            tyAcauisition.setHorizontal_accuracy(vo.getTyhzb()); //统一横坐标
            tyAcauisition.setVertical_accuracy(vo.getTyzzb()); //统一纵坐标
            tyAcauisition.setRow_created_by(vo.getV_login());
            tyAcauisition.setRowState(vo.getRowState());
            tyAcauisitionJson = (JSONObject) JSONObject.toJSON(tyAcauisition);
            tyacquisitionList.add(tyAcauisitionJson);

            //录入初始坐标集关联数据
            csAcauisition.setAcquisition_id(vo.getCszbcjid()); // 初始坐标采集id
            csAcauisition.setHorizontal_accuracy(vo.getCshzb()); //初始横坐标
            csAcauisition.setVertical_accuracy(vo.getCszzb()); //初始纵坐标
            csAcauisition.setRow_created_by(vo.getV_login());
            csAcauisition.setRowState(vo.getRowState());
            csAcauisitionJson = (JSONObject) JSONObject.toJSON(csAcauisition);
            csacquisitionList.add(csAcauisitionJson);

            //录入井斜测量数据
            wellDirSrvy.setUwi(vo.getUwi());
            //TODO 类型转换时判断前端传值是否为空
            wellDirSrvy.setSurvey_ref_num(vo.getBdh().toString());
            wellDirSrvy.setRpt_tie_tvd(Integer.parseInt(vo.getBdcs()));

            wellDirSrvy.setSurvey_id(vo.getSurvey_id());
            wellDirSrvy.setSurvey_type(vo.getBdlxdm());
            wellDirSrvy.setRow_created_by(vo.getV_login());
            wellDirSrvy.setRemark(vo.getZbyq());
            wellDirSrvy.setRowState(vo.getRowState());
            wellDirSrvyJson = (JSONObject) JSONObject.toJSON(wellDirSrvy);
            wellDirSrvyList.add(wellDirSrvyJson);
        }
        //执行well_node表插入
        String tyObj = HttpUtil.httpPost(tyList.toString(), UrlConstant.WELL_NODE_URL);
        String csObj = HttpUtil.httpPost(csList.toString(), UrlConstant.WELL_NODE_URL);
        //执行CsCoordAcauisition表插入
        String tyAcauisitionObj = HttpUtil.httpPost(tyacquisitionList.toString(), UrlConstant.CS_COORD_ACQUISITION_URL);
        String csAcauisitionObj = HttpUtil.httpPost(csacquisitionList.toString(), UrlConstant.CS_COORD_ACQUISITION_URL);
        //执行well_dir_srvy表插入
        String wellDirSrvyObj = HttpUtil.httpPost(wellDirSrvyList.toString(),UrlConstant.WELL_DIR_SRVY_URL);
        HashMap<String, String> map = new HashMap<>();
        map.put("统一录入WELL_NODE", tyObj);
        map.put("初始录入WELL_NODE", csObj);
        map.put("统一坐标集CS_COORD_ACQUISITION", tyAcauisitionObj);
        map.put("初始坐标集CS_COORD_ACQUISITION", csAcauisitionObj);
        map.put("井斜测量WELL_DIR_SRVY",wellDirSrvyObj);
        return map;
    }
}
