package com.nadeit.mj.service;

import com.nadeit.mj.domain.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 权限(Role)表服务接口
 *
 * @author makejava
 * @since 2023-07-31 21:30:46
 */
public interface RoleService extends IService<Role> {
    List<String> getRoleNameList(List<Long> roleIdList);
}

