package com.nadeit.mj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nadeit.mj.domain.entity.UserCompany;
import com.nadeit.mj.mapper.UserCompanyMapper;
import com.nadeit.mj.service.UserCompanyService;
import org.springframework.stereotype.Service;

/**
 * (UserCompany)表服务实现类
 *
 * @author makejava
 * @since 2023-08-05 19:32:31
 */
@Service("userCompanyService")
public class UserCompanyServiceImpl extends ServiceImpl<UserCompanyMapper, UserCompany> implements UserCompanyService {
}

