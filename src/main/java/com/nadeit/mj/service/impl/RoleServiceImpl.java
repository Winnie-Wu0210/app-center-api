package com.nadeit.mj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nadeit.mj.domain.entity.Role;
import com.nadeit.mj.mapper.RoleMapper;
import com.nadeit.mj.service.RoleService;
import com.nadeit.mj.utils.MyError;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限(Role)表服务实现类
 *
 * @author makejava
 * @since 2023-07-31 21:30:46
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Override
    public List<String> getRoleNameList(List<Long> roleIdList) {
        if(roleIdList == null || roleIdList.size() == 0){
            throw new MyError("该用户暂时没有角色");
        }
        LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(Role::getId, roleIdList);
        List<Role> roleList = this.list(wrapper);

        return roleList.stream().map(Role::getName).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
}

