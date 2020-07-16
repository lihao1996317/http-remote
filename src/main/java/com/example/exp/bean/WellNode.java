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
public class WellNode {
    /**
     * 节点ID
     */
    private String node_id;
    /**
     * 有效标识
     */
    private String active_ind = "Y";
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
     * 生效日期
     */
    private Date effective_date = new Date();
    /**
     * 失效日期
     */
    private Date expiry_date = DateUtil.parseStrToDate("9999/12/31","9999/12/31");
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
     * PPDM_GUID
     */
    private String ppdm_guid;
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
    /**
     * 行更改人
     */
    private String row_changed_by;
    /**
     * 行更改日期
     */
    private Date row_changed_date;
    /**
     * 行创建人
     */
    private String row_created_by;
    /**
     * 行创建日期
     */
    private Date row_created_date = new Date();
    /**
     * 行有效日期
     */
    private Date row_effective_date;
    /**
     * 行失效日期
     */
    private Date row_expiry_date;
    /**
     * 行质量
     */
    private Date row_quality;


}
