package com.nadeit.mj.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 应用列表(App)实体类
 *
 * @author makejava
 * @since 2023-08-05 19:31:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class App implements Serializable {
    private static final long serialVersionUID = 325563120863000601L;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * app名字
     */
    @TableField(value = "name")
    private String name;

    /**
     * applogo
     */
    @TableField(value = "logo")
    private String logo;

    /**
     * app描述
     */
    @TableField(value = "description")
    private String description;

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

