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
    private String nodeId;
    /**
     * 有效标识
     */
    private String activeInd = "Y";
    /**
     * 坐标质量
     */
    private String coordinateQuality;
    /**
     * 坐标采集ID
     */
    private String coordAquisitionId;
    /**
     * 坐标系ID
     */
    private String coordSystemId;
    /**
     * 生效日期
     */
    private Date effectiveDate = new Date();
    /**
     * 失效日期
     */
    private Date expiryDate = DateUtil.parseStrToDate("9999/12/31","9999/12/31");
    /**
     * 纬度
     */
    private Double latitude;
    /**
     * 法定测量类型
     */
    private String legalSurveyType;
    /**
     * 本地坐标系ID
     */
    private String localCoordSystemId;
    /**
     * 位置质量
     */
    private String locationQuality;
    /**
     * 位置类型
     */
    private String locationType;
    /**
     * 经度
     */
    private Double longtude;
    /**
     * 节点位置
     */
    private String nodePosition;
    /**
     * 原始序号
     */
    private Integer originalObsNo;
    /**
     * 原始XY单位
     */
    private String originalXyUom;
    /**
     * 平台ID
     */
    private String platformId;
    /**
     * 平台支持设施子类型
     */
    private String platformSfSubType;
    /**
     * PPDM_GUID
     */
    private String ppdmGuid;
    /**
     * 首选标识
     */
    private String preferredInd;
    /**
     * 备注
     */
    private String remark;
    /**
     * 选定序号
     */
    private Integer selectedObsNo;
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
    private String rowChangedBy;
    /**
     * 行更改日期
     */
    private Date rowChangedDate;
    /**
     * 行创建人
     */
    private String rowCreateBy;
    /**
     * 行创建日期
     */
    private Date rowCreatedDate = new Date();
    /**
     * 行有效日期
     */
    private Date rowEffectiveDate;
    /**
     * 行失效日期
     */
    private Date rowExpriryDate;
    /**
     * 行质量
     */
    private Date rowQuality;


}
