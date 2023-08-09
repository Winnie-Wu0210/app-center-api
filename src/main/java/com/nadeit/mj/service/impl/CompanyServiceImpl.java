package com.nadeit.mj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nadeit.mj.domain.entity.Company;
import com.nadeit.mj.mapper.CompanyMapper;
import com.nadeit.mj.service.CompanyService;
import org.springframework.stereotype.Service;

/**
 * 公司(Company)表服务实现类
 *
 * @author makejava
 * @since 2023-08-05 19:32:31
 */
@Service("companyService")
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {
}

