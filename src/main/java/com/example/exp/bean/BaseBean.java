package com.example.exp.bean;

import lombok.Data;

/**
 * BaseBean
 * 通用数据基类
 * @author xzr
 * 2020/7/20 14:41
 **/
@Data
public class BaseBean {
    /**
     * 行更改人
     */
    private String row_changed_by;
    /**
     * 行改日期
     */
    private String row_changed_date;
    /**
     * 行创建人
     */
    private String row_created_by;
    /**
     * 行创建日期
     */
    private String row_created_date;
    /**
     * 行生效日期（插入当前日期）
     */
    private String row_effective_date;
    /**
     * 行失效日期
     */
    private String row_expiry_date;
    /**
     * 行质量
     */
    private String row_quality;
    /**
     * 是否有效
     */
    private String active_ind = "Y";
    /**
     * 行状态☆
     */
    private String rowState;
    /**
     * 备注
     */
    private String remark;
    /**
     * 生效日期
     */
    private String effective_date;
    /**
     * 失效日期（9999-12-31）
     */
    private String expiry_date;
    /**
     * 全局ID
     */
    private String ppdm_guid;
}
