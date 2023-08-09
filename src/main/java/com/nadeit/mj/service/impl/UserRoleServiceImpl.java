package com.nadeit.mj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nadeit.mj.domain.entity.UserRole;
import com.nadeit.mj.mapper.UserRoleMapper;
import com.nadeit.mj.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * (UserRole)表服务实现类
 *
 * @author makejava
 * @since 2023-07-31 21:40:59
 */
@Service("userRoleService")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Override
    public List<Long> getRoleIdList(Long loginId) {
        LambdaQueryWrapper<UserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserRole::getUserId, loginId);
        List<UserRole> userRoleList = this.list(wrapper);

        return userRoleList.stream().map(UserRole::getRoleId).collect(Collectors.toList());
    }
}

