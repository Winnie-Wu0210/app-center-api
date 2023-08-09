package com.nadeit.mj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nadeit.mj.domain.dto.UserLoginDTO;
import com.nadeit.mj.domain.entity.User;
import com.nadeit.mj.domain.vo.GetLoginInfoVO;
import com.nadeit.mj.domain.vo.LoginVO;

import java.util.List;

public interface UserService extends IService<User> {

    LoginVO login(UserLoginDTO dto);

    Object getLoginInfo();

    Object getUserInfo(Long id);

    List<String> getRoleList(Long loginId);
}
