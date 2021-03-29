package com.twy.secondkill.service.impl;

import com.twy.secondkill.entity.User;
import com.twy.secondkill.mapper.UserMapper;
import com.twy.secondkill.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author gongpeng
 * @since 2021-03-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
