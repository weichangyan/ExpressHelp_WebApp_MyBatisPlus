package com.wcy.mpdemo.service.impl;

import com.wcy.mpdemo.entity.Order;
import com.wcy.mpdemo.mapper.OrderMapper;
import com.wcy.mpdemo.service.OrderService;
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
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
