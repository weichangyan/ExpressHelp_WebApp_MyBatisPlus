package com.wcy.mpdemo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wcy.mpdemo.entity.Order;
import com.wcy.mpdemo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceTest {

    /*注入业务层*/
    @Autowired
    private OrderService orderService;
    @Test
    void page() {
        // Step1：创建一个 Page 对象
        Page<Order> page = new Page<>();
        // Page<Order> page = new Page<>(2, 5);
        // Step2：调用 mybatis-plus 提供的分页查询方法
        orderService.page(page, null);
        // Step3：获取分页数据
        System.out.println(page.getCurrent()); // 获取当前页
        System.out.println(page.getTotal()); // 获取总记录数
        System.out.println(page.getSize()); // 获取每页的条数
        System.out.println(page.getRecords()); // 获取每页数据的集合
        System.out.println(page.getPages()); // 获取总页数
        System.out.println(page.hasNext()); // 是否存在下一页
        System.out.println(page.hasPrevious()); // 是否存在上一页
    }

    @Test
    void testQueryWrapper() {
        // Step1：创建一个 QueryWrapper 对象
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();

        // Step2： 构造查询条件
        queryWrapper
                .select("id", "customer_name", "express_type")
                .gt("id", 47);

        // Step3：执行查询
        orderService
                .list(queryWrapper)
                .forEach(System.out::println);
    }
}