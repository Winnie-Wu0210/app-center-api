package com.nadeit.mj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nadeit.mj.domain.entity.CompanyAppAdmin;
import com.nadeit.mj.mapper.CompanyAppAdminMapper;
import com.nadeit.mj.service.CompanyAppAdminService;
import org.springframework.stereotype.Service;

/**
 * (CompanyAppAdmin)表服务实现类
 *
 * @author makejava
 * @since 2023-08-05 19:32:31
 */
@Service("companyAppAdminService")
public class CompanyAppAdminServiceImpl extends ServiceImpl<CompanyAppAdminMapper, CompanyAppAdmin> implements CompanyAppAdminService {
}

