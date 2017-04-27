package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.CommentDao;
import com.heitian.ssm.dao.PostDao;
import com.heitian.ssm.service.CommentService;
import com.heitian.ssm.service.PostService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class CommentServiceImpl implements CommentService {
    
    @Resource
    private CommentDao commentDao;

}
