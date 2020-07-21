package com.example.exp.bean;

import lombok.Data;

/**
 * @author 李昊
 * @Title:
 * @Package
 * @Description:
 * @date 2020/7/21 17:28
 */
@Data
public class WellDirSrvy extends BaseBean{

    /**
     * 井ID
     */
    private String uwi;

    /**
     * 测量ID
     */
    private String survey_id;

    /**
     * 来源
     */
    private String source;

    /**
     * 方位坐标系ID
     */
    private String azimuth_coord_sys_id;

    /**
     * 方位坐标系可信程度
     */
    private String azimuth_coord_sys_qualifier;

    /**
     * 方位坐标系统备注
     */
    private String azimuth_coord_sys_remark;

    /**
     * 方位修正角
     */
    private Integer azimuth_corr_angle;

    /**
     * 方位修正角单位
     */
    private String azimuth_corr_angle_ouom;

    /**
     * 方位修正角类型
     */
    private String azimuth_corr_angle_type;

    /**
     * 底深
     */
    private Integer base_depth;

    /**
     * 底深单位
     */
    private String base_depth_ouom;

    /**
     * 计算方法
     */
    private String compute_method;

    /**
     * 保密类型
     */
    private String confidential_type;

    /**
     * 坐标采集ID
     */
    private String coord_acquisition_id;

    /**
     * 井斜测量分类
     */
    private String dir_survey_class;

    /**
     * 水平位移
     */
    private Integer extrapolate_depth;

    /**
     * 水平位移单位
     */
    private String extrapolate_depth_ouom;

    /**
     * 水平位移标志
     */
    private String extrapolate_ind;

    /**
     * 经纬度坐标系ID
     */
    private String geog_coord_sys_id;

    /**
     * 局部坐标系ID
     */
    private String local_coord_sys_id;

    /**
     * 磁偏角
     */
    private Integer magnetic_declination;

    /**
     * 磁偏角单位
     */
    private String magnetic_declination_ouom;

    /**
     * 磁偏角东西方向
     */
    private String mag_decl_ew_direction;

    /**
     * 偏移坐标系ID
     */
    private String offset_coord_sys_id;

    /**
     * 偏移坐标系可信程度
     */
    private String offset_coord_sys_qualifier;

    /**
     * 偏移坐标系统备注
     */
    private String offset_coord_sys_remark;

    /**
     * 偏移北方类型
     */
    private String offset_north_type;

    /**
     * 方位角
     */
    private Integer plane_of_proposal;

    /**
     * 方位角单位
     */
    private String plane_of_proposal_ouom;

    /**
     * 首选标识
     */
    private String preferred_ind;

    /**
     * 靶心半径
     */
    private Integer rad_uncert_dist;

    /**
     * 靶心半径单位
     */
    private String rad_uncert_dist_ouom;

    /**
     * 靶心半径原因
     */
    private String rad_uncert_dist_reason;

    /**
     * 记录方式
     */
    private String record_mode;

    /**
     * 报告高度高于基准面的高度
     */
    private Integer report_apd;

    /**
     * 报告测井基准面
     */
    private String report_log_datum;

    /**
     * 报告测井基准高程
     */
    private Integer report_log_datum_elev;

    /**
     * 报告基准高程单位
     */
    private String report_log_datum_elev_ouom;

    /**
     * 报告永久基准
     */
    private String report_perm_datum;

    /**
     * 报告永久基准高程
     */
    private Integer report_perm_datum_elev;

    /**
     * 报告永久基准高程单位
     */
    private String report_perm_datum_elev_ouom;

    /**
     * 采样间隔
     */
    private Integer resample_interval;

    /**
     * 采样间隔单位
     */
    private String resample_interval_ouom;

    /**
     * 报告坐标系ID
     */
    private String rpt_coord_sys_id;

    /**
     * 报告坐标系可信程度
     */
    private String rpt_coord_sys_qualifier;

    /**
     * 报告坐标系统备注
     */
    private String rpt_coord_sys_remark;

    /**
     * 报告修正角
     */
    private Integer rpt_corr_angle;

    /**
     * 报告修正角单位
     */
    private String rpt_corr_angle_ouom;

    /**
     * 报告修正角类型
     */
    private String rpt_corr_angle_type;

    /**
     * 报告北方类型
     */
    private String rpt_north_type;

    /**
     * 报告测量类型
     */
    private String rpt_survey_type;

    /**
     * 报告连续测量方位
     */
    private Integer rpt_tie_azimuth;

    /**
     * 报告连续测量方位单位
     */
    private String rpt_tie_azimuth_ouom;

    /**
     * 报告连续测量井斜角
     */
    private Integer rpt_tie_inclination;

    /**
     * 报告连续测量井斜角单位
     */
    private String rpt_tie_inclination_ouom;

    /**
     * 报告连续测量深度
     */
    private Integer rpt_tie_md;

    /**
     * 报告连续测量深度单位
     */
    private String rpt_tie_md_ouom;

    /**
     * 报告连续测量点标志
     */
    private String rpt_tie_point_ind;

    /**
     * 报告连续测量垂深
     */
    private Integer rpt_tie_tvd;

    /**
     * 报告连续测量垂深单位
     */
    private String rpt_tie_tvd_ouom;

    /**
     * 报告连续测量X位移
     */
    private Integer rpt_tie_x_offset;

    /**
     * 报告连续测量X位移方位
     */
    private String rpt_tie_x_offset_ew_dir;

    /**
     * 报告连续测量X位移单位
     */
    private String rpt_tie_x_offset_ouom;

    /**
     * 报告连续测量Y位移
     */
    private Integer rpt_tie_y_offset;

    /**
     * 报告连续测量Y位移方位
     */
    private String rpt_tie_y_offset_ns_dir;

    /**
     * 报告连续测量Y位移单位
     */
    private String rpt_tie_y_offset_ouom;

    /**
     * 源文档ID
     */
    private String source_docement_id;

    /**
     * 合作测量公司ID
     */
    private String survey_company_ba_id;

    /**
     * 合作测量编辑ID
     */
    private String survey_compiler_ba_id;

    /**
     * 提供测量数据ID
     */
    private String servey_digital_prvdr_ba_id;

    /**
     * 测量结束日期
     */
    private String survey_end_date;

    /**
     * 测量结束日期可信程度
     */
    private String survey_end_date_qualifier;

    /**
     * 测量数据处理方法
     */
    private String survey_process_method;

    /**
     * 测量质量
     */
    private String survey_quality;

    /**
     * 测量引用编号
     */
    private String survey_ref_num;

    /**
     * 测量数据报告类型
     */
    private String survey_report_type;

    /**
     * 调查运行数
     */
    private String survey_run_num;

    /**
     * 调查开始日期
     */
    private String survey_start_date;

    /**
     * 调查开始日期限定
     */
    private String survey_start_date_qualifier;

    /**
     * 测量类型
     */
    private String survey_type;

    /**
     * 顶深
     */
    private Integer top_depth;

    /**
     * 顶深单位
     */
    private String top_depth_ouom;
}
