package com.nadeit.mj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nadeit.mj.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
