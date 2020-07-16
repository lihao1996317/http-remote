package com.example.exp.vo;


import lombok.Data;

/**
 * WellheadCoordinateDTO
 *
 * @author xzr
 * 2020/7/15 10:16
 * 封装井口查询数据DTO
 **/
@Data
public class WallheadCoordinateVo {
    /**
     * 井号
     */
    private String jh;
    /**
     * 序号
     */
    private String xh;
    /**
     * 坐标类型
     */
    private String zblx;
    /**
     * 通用坐标系
     */
    private String tyzbx;
    /**
     * 通用纵坐标
     */
    private Double tyzzb;
    /**
     * 通用横坐标
     */
    private Integer tyhzb;
    /**
     * 初始坐标系
     */
    private String cszbx;
    /**
     * 初始枞坐标
     */
    private Double cszzb;
    /**
     * 初始横坐标
     */
    private Double cshzb;
    /**
     * 经度
     */
    private Double jd;
    /**
     * 纬度
     */
    private Double wd;
    /**
     * 备注
     */
    private String bz;
    /**
     * 通用节点ID
     */
    private String tyjdid;
    /**
     * 初始节点ID
     */
    private String csjdid;
    /**
     * 统一坐标采集ID
     */
    private String tyzbcjid;
    /**
     * 初始坐标采集ID
     */
    private String cszbcjid;
    /**
     * 坐标类型ID
     */
    private String zblxid;
    /**
     * 统一坐标系ID
     */
    private String tyzbxid;
    /**
     * 初始坐标系ID
     */
    private String cszbxid;
}
