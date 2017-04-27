package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.UserDao;
import com.heitian.ssm.model.User;
import com.heitian.ssm.service.UserService;
import com.heitian.ssm.utils.HelperFunc;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.security.MessageDigest;
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

    public User selectUserByuserNameAnduserPwd(String userName,String userPwd){
        return userDao.selectUserByuserNameAnduserPwd(userName,HelperFunc.md5(userPwd));
    }
    
    public User getUserByPhoneOrEmail(String emailOrPhone, Short state) {
        return userDao.selectUserByPhoneOrEmail(emailOrPhone,state);
    }
    
    public List<User> getAllUser() {
        return userDao.selectAllUser();
    }

    public User addUser(String userName,String userPhone,String userEmail,String userPwd,String pwdSalt){
        Long ctime = new Date().getTime();
        Long mtime = new Date().getTime();
        Short isDelete = 0;
        return userDao.addUser(userName,userPhone,userEmail,HelperFunc.md5(userPwd),pwdSalt,ctime,mtime,isDelete);
    }

    public void delUser(Long userId){
        userDao.delUser(userId);
    }

    public User updateUser(User user){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long mtime = new Date().getTime();
        return userDao.updateUser(user.getId(),user.getUserName(),user.getUserPhone(),user.getUserEmail(),user.getUserPwd(),mtime);
    }
}
