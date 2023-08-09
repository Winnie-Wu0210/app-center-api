package com.nadeit.mj.service;

import com.nadeit.mj.domain.entity.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * (UserRole)表服务接口
 *
 * @author makejava
 * @since 2023-07-31 21:40:59
 */
public interface UserRoleService extends IService<UserRole> {
    List<Long> getRoleIdList(Long loginId);
}

