package com.nadeit.mj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nadeit.mj.domain.entity.App;

public interface AppService extends IService<App> {
    App getOneById(Long id);

}
