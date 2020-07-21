package com.example.exp.bean;

import lombok.Data;

import java.sql.Blob;

/**
 * @author 李昊
 * @Title: 记录-文件内容表 实体类
 * @Package
 * @Description:
 * @date 2020/7/21 14:42
 */
@Data
public class RmFileContent extends BaseBean{

    /**
     * 文件ID
     */
    private String file_id;

    /**
     * 数字格式
     */
    private String digital_format;

    /**
     * 文件内容
     */
    private Blob file_content;

    /**
     * 文件大小
     */
    private Double file_size;

    /**
     * 文件大小单位
     */
    private String file_size_uom;

    /**
     * 记录ID
     */
    private String information_item_id;

    /**
     * 记录子类型
     */
    private String info_item_subtype;

    /**
     * 实物ID
     */
    private String physical_item_id;

    /**
     * 来源
     */
    private String source;

    /**
     * 应用系统ID
     */
    private String sw_application_id;


}
