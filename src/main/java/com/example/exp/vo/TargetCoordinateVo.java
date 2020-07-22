package com.example.exp.vo;

import lombok.Data;

/**
 * @author 李昊
 * @Title:  靶点坐标VO类
 * @Package
 * @Description:  对应靶点坐标前端字段生成的DTO
 * @date 2020/7/21 18:13
 */
@Data
public class TargetCoordinateVo {

    /**
     * 井号
     */
    private String uwi;

    /**
     * 靶点号
     */
    private Integer bdh;

    /**
     * 靶点类型代码
     */
    private String bdlxdm;

    /**
     * 靶点类型
     */
    private String bdlx;

    /**
     * 靶点名称
     */
    private String bdmc;

    /**
     * 统一坐标系ID
     */
    private String tyzbxid;

    /**
     * 统一坐标系
     */
    private String tyzbx;

    /**
     * 统一坐标采集ID
     */
    private String tyzbcjid;

    /**
     * 统一横坐标
     */
    private Integer tyhzb;

    /**
     * 统一纵坐标
     */
    private Double tyzzb;

    /**
     * 初始坐标系ID
     */
    private String cszbxid;

    /**
     * 初始坐标系
     */
    private String cszbx;

    /**
     * 初始坐标采集ID
     */
    private String cszbcjid;

    /**
     * 初始横坐标
     */
    private Integer cshzb;

    /**
     * 初始纵坐标
     */
    private Double cszzb;

    /**
     * 经度
     */
    private Double jd;

    /**
     * 纬度
     */
    private Double wd;

    /**
     * 统一节点ID
     */
    private String tyjdid;

    /**
     * 初始节点ID
     */
    private String csjdid;

    /**
     * 靶点垂深
     */
    private String bdcs;

    /**
     * 造斜点深度
     */
    private String zxdsd;

    /**
     * 中靶要求
     */
    private String zbyq;

    /**
     * 备注
     */
    private String bz;

    /**
     * 登录人
     */
    private String v_login;

    /**
     * rowState 执行标识
     */
    private String rowState;

    /**
     * 测量id (前端随机生成)
     */
    private String  survey_id;

}