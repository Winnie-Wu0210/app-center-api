package com.nadeit.mj.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nadeit.mj.domain.dto.UserLoginDTO;
import com.nadeit.mj.domain.entity.Role;
import com.nadeit.mj.domain.entity.UserRole;
import com.nadeit.mj.domain.vo.GetLoginInfoVO;
import com.nadeit.mj.domain.vo.LoginVO;
import com.nadeit.mj.service.RoleService;
import com.nadeit.mj.service.UserRoleService;
import com.nadeit.mj.service.UserService;
import com.nadeit.mj.utils.MyError;
import com.nadeit.mj.utils.RedisCache;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nadeit.mj.domain.entity.User;
import com.nadeit.mj.mapper.UserMapper;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private RoleService roleService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private RedisCache redisCache;

    @Override
    public LoginVO login(UserLoginDTO dto) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, dto.getUsername());
        User user = this.getOne(wrapper);

        if (user == null) {
            throw new MyError("用户不存在");
        }

        String password = user.getPassword();
        if (password.equals(dto.getPassword())) {
            StpUtil.login(user.getId());

            String redisKey = "common:user:role:user_" + user.getId();
            redisCache.deleteObject(redisKey);

            return LoginVO.builder()
                    .token(StpUtil.getTokenValue())
                    .build();
        } else {
            throw new MyError("密码错误");
        }
    }

    @Override
    public Object getLoginInfo() {
        Long userId = StpUtil.getLoginIdAsLong();
        User user = this.getById(userId);

        GetLoginInfoVO vo = new GetLoginInfoVO();
        vo.setUserId(user.getId());
        vo.setUsername(user.getUsername());

        //到目前为止，我们已经获取到了用户的基本信息，但是我们还需要获取用户的角色信息

        LambdaQueryWrapper<UserRole> wrapper1 = new LambdaQueryWrapper<>();
        wrapper1.eq(UserRole::getUserId, user.getId());
        List<UserRole> userRoleList = userRoleService.list(wrapper1);

        List<Long> userRoleIdList = new ArrayList<>();
        for (UserRole userRole : userRoleList) {
            userRoleIdList.add(userRole.getRoleId());
        }

        if (userRoleIdList.size() == 0) {
            vo.setRole(new ArrayList<>());
            return vo;
        }

        LambdaQueryWrapper<Role> wrapper2 = new LambdaQueryWrapper<>();
        wrapper2.in(Role::getId, userRoleIdList);
        List<Role> roleList = roleService.list(wrapper2);

        List<String> roleNameList = new ArrayList<>();
        for (Role role : roleList) {
            roleNameList.add(role.getName());
        }

        vo.setRole(roleNameList);

        return vo;
    }

    @Override
    public Object getUserInfo(Long id) {
        return this.getById(id);
    }

    @Override
    public List<String> getRoleList(Long loginId) {
        String redisKey = "common:user:role:user_" + loginId;
        List<String> roleList = redisCache.getCacheObject(redisKey);
        if (roleList != null) {
            return roleList;
        }

        List<Long> roleIdList = userRoleService.getRoleIdList(loginId);
        List<String> roleNameList = roleService.getRoleNameList(roleIdList);

        redisCache.setCacheObject(redisKey, roleNameList, 1, TimeUnit.DAYS);

        return roleNameList;
    }
}
