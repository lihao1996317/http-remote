package com.example.exp.bean;

import com.example.exp.utils.DateUtil;
import lombok.Data;

import java.util.Date;

/**
 * CsCoordAcauisition
 *
 * @author xzr
 * 2020/7/17 14:19
 **/
@Data
public class CsCoordAcauisition extends BaseBean{
    /**
     * 坐标采集ID
     */
    private String acquisition_id;
    /**
     * 采集人ID
     */
    private String acquired_by_ba_id;
    /**
     * 有效标识
     */
    private String active_ind = "Y";
    /**
     * 获取方法
     */
    private String capture_method;
    /**
     * 计算方法
     */
    private String compute_method;
    /**
     * 坐标质量
     */
    private String coordinate_quality;
    /**
     * 数据创建日期
     */
    private String data_create_date = DateUtil.parseDateToStr(new Date(), "yyyy-MM-dd");
    /**
     * 数字化比例尺
     */
    private Integer digitized_scale;
    /**
     * 水平精度
     */
    private Integer horizontal_accuracy;
    /**
     * 水平精度原始单位
     */
    private String horizontal_accuracy_ouom;
    /**
     * 来源
     */
    private String source;
    /**
     * 来源比例尺
     */
    private Integer source_scale;
    /**
     * 测量精度
     */
    private Integer survey_accuracy;
    /**
     * 转换ID
     */
    private String transform_id;
    /**
     * 垂直精度
     */
    private Double vertical_accuracy;
    /**
     * 垂直精度原始单位
     */
    private String vertical_accuracy_ouom;
}
