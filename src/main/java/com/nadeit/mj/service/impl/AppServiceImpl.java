package com.nadeit.mj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nadeit.mj.domain.entity.App;
import com.nadeit.mj.mapper.AppMapper;
import com.nadeit.mj.service.AppService;
import org.springframework.stereotype.Service;

@Service("appService")
public class AppServiceImpl extends ServiceImpl<AppMapper, App> implements AppService {
    @Override
    public App getOneById(Long id) {
       return this.getById(id);
    }


}
