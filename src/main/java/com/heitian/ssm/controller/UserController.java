package com.heitian.ssm.controller;

import com.heitian.ssm.model.User;
import com.heitian.ssm.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model){
        log.info("查询所有用户信息");
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList",userList);
        return "showUser";
    }

    @RequestMapping("/addUser")
    public String addUser(HttpServletRequest request, Model model){
        log.info("添加用户信息");
        return "addUser";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request, Model model){
        String userName = request.getParameter("userName");
        String userPhone = request.getParameter("userPhone");
        String userEmail = request.getParameter("userEmail");
        String userPwd = request.getParameter("pwd");
        String pwdSalt = "sadas";
        userService.addUser(userName,userPhone,userEmail,userPwd,pwdSalt);
        log.info("添加用户信息成功");
        return "addUser";
    }

    @RequestMapping("/del")
    public String delUser(HttpServletRequest request, Model model){
        String id = request.getParameter("id");
        Long userId = new Long(id);
        userService.delUser(userId);
        return "redirect:/user/showUser";
    }

    @RequestMapping("/updateUser")
    public String updateUser(HttpServletRequest request, Model model){
        String id = request.getParameter("id");
        Long userId = new Long(id);
        User user = userService.getUserById(userId);
        model.addAttribute("user",user);
        return "updateUser";
    }

    @RequestMapping("/update")
    public String update(HttpServletRequest request, Model model){
        String id = request.getParameter("id");
        String userName = request.getParameter("userName");
        String userPhone = request.getParameter("userPhone");
        String userEmail = request.getParameter("userEmail");
        String userPwd = request.getParameter("pwd");
        Long userId = new Long(id);

        User user = userService.getUserById(userId);
        user.setUserName(userName);
        user.setUserPhone(userPhone);
        user.setUserEmail(userEmail);
        user.setUserPwd(userPwd);
        userService.updateUser(user);
        return "redirect:/user/showUser";
    }
}
