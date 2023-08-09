package com.nadeit.mj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nadeit.mj.domain.entity.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * 权限(Role)表数据库访问层
 *
 * @author makejava
 * @since 2023-07-31 21:30:46
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}

