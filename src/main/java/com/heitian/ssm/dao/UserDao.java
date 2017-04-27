package com.heitian.ssm.dao;

import com.heitian.ssm.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Repository
public interface UserDao {

    User selectUserById(@Param("userId") Long userId);

    User selectUserByuserNameAnduserPwd(@Param("userName") String userName,@Param("userPwd") String userPwd);

    User selectUserByPhoneOrEmail(@Param("emailOrPhone") String emailOrPhone, @Param("state") Short state);

    List<User> selectAllUser();

    User addUser(@Param("userName") String userName,@Param("userPhone")String userPhone,@Param("userEmail")String userEmail,@Param("userPwd")String userPwd,@Param("pwdSalt")String pwdSalt,@Param("ctime")Long ctime,@Param("mtime")Long mtime,@Param("isDelete")short isDelete);

    void delUser(@Param("userId")Long userId);

    User updateUser(@Param("userId") Long userId,@Param("userName") String userName,@Param("userPhone")String userPhone,@Param("userEmail")String userEmail,@Param("userPwd")String userPwd,@Param("mtime")Long mtime);
}
