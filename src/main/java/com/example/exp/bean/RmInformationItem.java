package com.example.exp.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @author 李昊
 * @Title: 记录表 实体类
 * @Package
 * @Description:
 * @date 2020/7/21 11:45
 */
@Data
public class RmInformationItem {
    /**
     * 记录子类型
     */
    private String info_item_subtype;

    /**
     * 记录ID
     */
    private String information_item_id;

    /**
     * 摘要
     * TODO 关键字通过注解解决变量名冲突
     */
    @SerializedName("abstract")
    private String Abstract;

    /**
     * 接收日期
     */
    private String accepted_date;

    /**
     * 访问条件
     */
    private String access_condition;

    /**
     * 可用日期
     */
    private String available_date;

    /**
     * 坐标ID
     */
    private String coord_acquisition_id;

    /**
     * 版权日期
     */
    private String copyright_date;

    /**
     * 生效日期
     */
    private String effective_date;

    /**
     * 失效日期
     */
    private String expiry_date;

    /**
     * 地理坐标系统ID
     */
    private String geog_coord_system_id;

    /**
     * 分组标志
     */
    private String group_ind;

    /**
     * 发行日期
     */
    private String issue_date;

    /**
     * 条目分类
     */
    private String item_category;

    /**
     * 条目子分类
     */
    private String item_sub_category;

    /**
     * 本地坐标系ID
     */
    private String local_coord_system_id;

    /**
     * 地图坐标系统ID
     */
    private String map_coord_system_id;

    /**
     * 最大纬度
     */
    private Integer max_latitude;

    /**
     * 最大经度
     */
    private Integer max_longitude;

    /**
     * 最小纬度
     */
    private Integer min_latitude;

    /**
     * 最小经度
     */
    private Integer min_longitude;

    /**
     * 修改日期
     */
    private String modified_date;

    /**
     * 初始日期
     */
    private String origin_date;

    /**
     * 公布日期
     */
    private String publish_date;

    /**
     * 目标
     */
    private String purpose;

    /**
     * 引用编号
     */
    private String reference_num;

    /**
     * 安全描述
     */
    private String security_desc;

    /**
     * 来源
     */
    private String source;

    /**
     * 源文献ID
     */
    private String source_document_id;

    /**
     * 提交日期
     */
    private String submit_date;

    /**
     * 保存日期
     */
    private String time_period_desc;

    /**
     * 标题
     */
    private String title;

    /**
     * 使用条件
     */
    private String use_condition;

    /**
     * 版本号
     */
    private String version_num;


}
