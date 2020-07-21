package com.example.exp.bean;

import lombok.Data;

/**
 * @author 李昊
 * @Title: 记录-文件表 实体类
 * @Package
 * @Description:
 * @date 2020/7/21 14:38
 */
@Data
public class RmDocument extends BaseBean {
    /**
     * 记录子类型
     */
    private String info_item_subtype;

    /**
     * 记录ID
     */
    private String information_item_id;

    /**
     * 文件状态
     */
    private String document_status;

    /**
     * 文件类型
     */
    private String document_type;

    /**
     * 来源
     */
    private String source;

    /**
     * 文献来源ID
     */
    private String source_document_id;

}
