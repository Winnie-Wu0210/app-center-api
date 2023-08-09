package com.nadeit.mj.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (CompanyAppAdmin)实体类
 *
 * @author makejava
 * @since 2023-08-05 19:31:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyAppAdmin implements Serializable {
    private static final long serialVersionUID = -28379254863726323L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "app_id")
    private Long appId;

    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "craete_time")
    private Date craeteTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}

