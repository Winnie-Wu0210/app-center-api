package com.nadeit.mj.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import com.nadeit.mj.domain.entity.App;
import com.nadeit.mj.service.AppService;
import com.nadeit.mj.utils.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController()
@RequestMapping("/mj/app")
@SaCheckLogin()
public class AppController {
    @Resource
    private AppService appService;

    // 获取应用列表
    @GetMapping("/getAppList")
    public Response<List<App>> getAppList() {
        return Response.success(appService.list());
    }
}
