package com.heitian.ssm.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created by kpp on 2017/4/11.
 */
public class HelperFunc {

    public static String md5(String str){
        String res = "";
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            res = new BigInteger(1, md.digest()).toString(16);
        }catch (Exception e){
            //throw new RuntimeException("MD5加密出现错误");
        }
        return res;
    }
}
