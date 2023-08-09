package com.nadeit.mj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nadeit.mj.domain.entity.CompanyApp;
import com.nadeit.mj.mapper.CompanyAppMapper;
import com.nadeit.mj.service.CompanyAppService;
import org.springframework.stereotype.Service;

/**
 * 公司平台(CompanyApp)表服务实现类
 *
 * @author makejava
 * @since 2023-08-05 19:32:31
 */
@Service("companyAppService")
public class CompanyAppServiceImpl extends ServiceImpl<CompanyAppMapper, CompanyApp> implements CompanyAppService {
}

