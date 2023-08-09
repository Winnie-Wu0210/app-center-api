package com.nadeit.mj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nadeit.mj.domain.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * (UserRole)表数据库访问层
 *
 * @author makejava
 * @since 2023-07-31 21:40:59
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {
}

