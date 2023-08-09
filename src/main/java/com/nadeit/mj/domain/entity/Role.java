package com.nadeit.mj.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限(Role)实体类
 *
 * @author makejava
 * @since 2023-08-05 19:31:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    private static final long serialVersionUID = 724863204461724708L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 权限名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 角色标签
     */
    @TableField(value = "label")
    private String label;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**创建时间*/
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**更新时间*/
    /**
     * 修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}

