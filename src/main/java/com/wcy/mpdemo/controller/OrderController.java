package com.wcy.mpdemo.controller;


import com.wcy.mpdemo.entity.AjaxRes;
import com.wcy.mpdemo.entity.Order;
import com.wcy.mpdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wcy
 * @since 2021-08-13
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    /*注入业务层*/
    @Autowired
    private OrderService orderService;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public Order getOrderById(@PathVariable("id") Integer id) {
        /*调用业务层根据id查询订单*/
        Order order = orderService.getById(id);
        return order;
    }

    @RequestMapping(value="/all", method=RequestMethod.GET)
    public List<Order> getAllOrders() {
        /*调用业务层获取所有订单*/
        List<Order> ordersList = orderService.list();
        return ordersList;
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public AjaxRes saveOrder(@RequestBody Order order) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            /*调用业务层,保存订单*/
            orderService.save(order);
            ajaxRes.setMsg("保存成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("保存失败");
        }
        return ajaxRes;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public AjaxRes updateOrder(@RequestBody Order order) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            /*调用业务层,更新订单*/
            Order order1 = orderService.getById(order);
            order1.setStatus(order.getStatus());
            order1.setEmployeeName(order.getEmployeeName());
            order1.setFulfilTime(order.getFulfilTime());
            orderService.updateById(order1);
            ajaxRes.setMsg("更新成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("更新失败");
        }
        return ajaxRes;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public AjaxRes removeOrder(Integer id) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            /*调用业务层,删除订单*/
            orderService.removeById(id);
            ajaxRes.setMsg("删除成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("删除失败");
        }
        return ajaxRes;
    }

}

