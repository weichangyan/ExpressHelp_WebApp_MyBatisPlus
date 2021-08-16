package com.wcy.mpdemo.service.impl;

import com.wcy.mpdemo.entity.User;
import com.wcy.mpdemo.mapper.UserMapper;
import com.wcy.mpdemo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wcy
 * @since 2021-08-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
