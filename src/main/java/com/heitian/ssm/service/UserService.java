package com.heitian.ssm.service;

import com.heitian.ssm.model.User;

import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */
public interface UserService {

    List<User> getAllUser();

    User getUserByPhoneOrEmail(String emailOrPhone, Short state);

    User getUserById(Long userId);

    User selectUserByuserNameAnduserPwd(String userName,String userPwd);

    User addUser(String userName,String userPhone,String userEmail,String userPwd,String pwdSalt);

    void delUser(Long userId);

    User updateUser(User user);
}
