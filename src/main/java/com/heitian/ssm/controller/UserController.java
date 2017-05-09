package com.heitian.ssm.controller;

import com.heitian.ssm.model.User;
import com.heitian.ssm.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    //查询用户列表
    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model){
        log.info("查询所有用户信息");
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList",userList);
        return "showUser";
    }

    //登录接口
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model){
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        User user = userService.selectUserByuserNameAnduserPwd(userName,userPwd);
        if(user == null){
            log.info("登录失败");
            model.addAttribute("errMsg","账号或密码错误");
            return "redirect:/user/login";
        }
        return "showUser";
    }

    //登录页面
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginView(HttpServletRequest request, Model model){
        return "login";
    }

    //注册
    @RequestMapping(value="/register",method = RequestMethod.POST)
    public String register(HttpServletRequest request, Model model){
        String userName = request.getParameter("userName");
        String userPhone = request.getParameter("userPhone");
        String userEmail = request.getParameter("userEmail");
        String userPwd = request.getParameter("pwd");
        String pwdSalt = "sadas";
        User user = userService.addUser(userName,userPhone,userEmail,userPwd,pwdSalt);
        log.info("添加用户信息成功");



        return "addUser";
    }

    //注册
    @RequestMapping(value="/register",method = RequestMethod.GET)
    public String registerView(HttpServletRequest request, Model model){
        log.info("添加用户信息");
        return "addUser";
    }

    //删除用户
    @RequestMapping(value="/delUser",method = RequestMethod.POST)
    public String delUser(HttpServletRequest request, Model model){
        String id = request.getParameter("id");
        Long userId = new Long(id);
        userService.delUser(userId);
        return "redirect:/user/showUser";
    }

    //修改用户
    @RequestMapping(value="/updateUser",method = RequestMethod.GET)
    public String updateUser(HttpServletRequest request, Model model){
        String id = request.getParameter("id");
        Long userId = new Long(id);
        User user = userService.getUserById(userId);
        model.addAttribute("user",user);
        return "updateUser";
    }

    //修改用户
    @RequestMapping(value="/updateUser",method = RequestMethod.POST)
    public String updateUserView(HttpServletRequest request, Model model){
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
