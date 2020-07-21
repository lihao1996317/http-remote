package com.example.exp.bean;

import com.example.exp.utils.DateUtil;
import lombok.Data;

import java.util.Date;

/**
 * WellNode
 *
 * @author xzr
 * 2020/7/15 17:56
 **/
@Data
public class WellNode extends BaseBean{
    /**
     * 节点ID
     */
    private String node_id;
    /**
     * 坐标质量
     */
    private String coordinate_quality;
    /**
     * 坐标采集ID
     */
    private String coord_acquisition_id;
    /**
     * 坐标系ID
     */
    private String coord_system_id;
    /**
     * 纬度
     */
    private Double latitude;
    /**
     * 法定测量类型
     */
    private String legal_survey_type;
    /**
     * 本地坐标系ID
     */
    private String local_coord_system_id;
    /**
     * 位置质量
     */
    private String location_quality;
    /**
     * 位置类型
     */
    private String location_type;
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 节点位置
     */
    private String node_position;
    /**
     * 原始序号
     */
    private Integer original_obs_no;
    /**
     * 原始XY单位
     */
    private String original_xy_uom;
    /**
     * 平台ID
     */
    private String platform_id;
    /**
     * 平台支持设施子类型
     */
    private String platform_sf_subtype;
    /**
     * 首选标识
     */
    private String preferred_ind;
    /**
     * 备注
     */
    private String remark;
    /**
     * 选定序号
     */
    private Integer selected_obs_no;
    /**
     * 来源
     */
    private String source = "JKZB";
    /**
     * 井ID
     */
    private String uwi;
}
