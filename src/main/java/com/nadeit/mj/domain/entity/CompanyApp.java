package com.nadeit.mj.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 公司平台(CompanyApp)实体类
 *
 * @author makejava
 * @since 2023-08-05 19:31:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyApp implements Serializable {
    private static final long serialVersionUID = -47465246688642554L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "company_id")
    private Long companyId;

    @TableField(value = "app_id")
    private Integer appId;

    @TableField(value = "start_date")
    private Date startDate;

    @TableField(value = "end_date")
    private Integer endDate;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}

