package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.UserDao;
import com.heitian.ssm.model.User;
import com.heitian.ssm.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    
    @Resource
    private UserDao userDao;

    public User getUserById(Long userId) {
        return userDao.selectUserById(userId);
    }
    
    public User getUserByPhoneOrEmail(String emailOrPhone, Short state) {
        return userDao.selectUserByPhoneOrEmail(emailOrPhone,state);
    }
    
    public List<User> getAllUser() {
        return userDao.selectAllUser();
    }

    public User addUser(String userName,String userPhone,String userEmail,String userPwd,String pwdSalt){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = formatter.format(date);
        String modifyTime = formatter.format(date);
        Short isDelete = 0;
        return userDao.addUser(userName,userPhone,userEmail,userPwd,pwdSalt,createTime,modifyTime,isDelete);
    }

    public void delUser(Long userId){
        userDao.delUser(userId);
    }

    public User updateUser(User user){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String modifyTime = formatter.format(date);
        return userDao.updateUser(user.getId(),user.getUserName(),user.getUserPhone(),user.getUserEmail(),user.getUserPwd(),modifyTime);
    }
}
