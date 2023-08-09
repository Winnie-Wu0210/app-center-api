package com.nadeit.mj.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import com.nadeit.mj.service.UserService;
import com.nadeit.mj.utils.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@SaCheckLogin
@RestController()
@RequestMapping("/mj/user")
public class UserController {


//        this.list(); //无需传递任何参数，或者传递一个wrapper
//        this.getById(); //需传递一个id
//        this.getOne(); //需传递一个wrapper
//        this.remove(); //需传递一个wrapper
//        this.removeById(); //需传递一个id
//        this.removeBatchByIds(); //需传递一个id集合
//        this.updateById();  //需传递一个实体对象

    @Resource
    private UserService userService;

    // 获取用户列表
    @SaCheckRole({"admin"})
    @GetMapping("/getUserList")
    public Object getUserList() {
        return userService.list();
    }

    // 获取用户信息
    @GetMapping("/getUserInfo")
    public Response getUserInfo(@RequestParam Long id) {
        if (id == null) {
            return Response.error("id不能为空");
        }
        return Response.success(userService.getUserInfo(id));
    }


}
