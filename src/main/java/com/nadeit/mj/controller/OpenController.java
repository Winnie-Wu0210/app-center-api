package com.nadeit.mj.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.nadeit.mj.domain.dto.UserLoginDTO;
import com.nadeit.mj.domain.vo.LoginVO;
import com.nadeit.mj.service.UserService;
import com.nadeit.mj.utils.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;

@RestController()
@RequestMapping("/mj")
@Tag(name = "开放接口", description = "这是很多开放的接口")
public class OpenController {
    @Resource
    private UserService UserService;

    // 登录
    @PostMapping("/login")
    @Operation(summary = "登录")
    public Response<LoginVO> login(@RequestBody @Validated UserLoginDTO dto) {
        return Response.success(UserService.login(dto));
    }

    // 获取登录用户信息
    @GetMapping("/getLoginInfo")
    @SaCheckLogin
    public Response getLoginInfo() {
        return Response.success(UserService.getLoginInfo());
    }

}
