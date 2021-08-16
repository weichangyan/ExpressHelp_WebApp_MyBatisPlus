package com.wcy.mpdemo.controller;


import com.wcy.mpdemo.entity.AjaxRes;
import com.wcy.mpdemo.entity.User;
import com.wcy.mpdemo.service.UserService;
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
@RequestMapping("/user")
public class UserController {

    /*注入业务层*/
    @Autowired
    private UserService userService;

    @RequestMapping(value="/{openid}", method= RequestMethod.GET)
    public User getUserById(@PathVariable("openid") String openid) {
        /*调用业务层根据id查询用户*/
        User user = userService.getById(openid);
        return user;
    }

    @RequestMapping(value="/all", method=RequestMethod.GET)
    public List<User> getAllUsers() {
        /*调用业务层获取所有用户*/
        List<User> usersList = userService.list();
        return usersList;
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public AjaxRes saveUser(@RequestBody User user) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            /*调用业务层,保存用户*/
            userService.save(user);
            ajaxRes.setMsg("保存成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("保存失败");
        }
        return ajaxRes;
    }

    @RequestMapping(value="/{openid}", method=RequestMethod.PUT)
    public AjaxRes updateUser(@RequestBody User user) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            /*调用业务层,更新用户*/
            User user1 = userService.getById(user);
            user1.setStuNum(user.getStuNum());
            user1.setNickName(user.getNickName());
            user1.setName(user.getName());
            user1.setPhone(user.getPhone());
            userService.updateById(user1);
            ajaxRes.setMsg("更新成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("更新失败");
        }
        return ajaxRes;
    }

    @RequestMapping(value="/{openid}", method=RequestMethod.DELETE)
    public AjaxRes removeUser(String openid) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            /*调用业务层,删除用户*/
            userService.removeById(openid);
            ajaxRes.setMsg("删除成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("删除失败");
        }
        return ajaxRes;
    }

}

