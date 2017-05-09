package com.heitian.ssm.controller;

import com.heitian.ssm.service.CommentService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/comment")
public class CommentController {

    private Logger log = Logger.getLogger(CommentController.class);
    @Resource
    private CommentService commentService;


}
