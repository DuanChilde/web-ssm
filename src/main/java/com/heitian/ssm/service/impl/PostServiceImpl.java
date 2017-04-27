package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.PostDao;
import com.heitian.ssm.model.Post;
import com.heitian.ssm.service.PostService;
import com.heitian.ssm.utils.HelperFunc;
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
public class PostServiceImpl implements PostService {
    
    @Resource
    private PostDao postDao;

}
