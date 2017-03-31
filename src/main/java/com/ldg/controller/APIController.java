package com.ldg.controller;

import com.ldg.api.service.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liudo on 2017/3/10 0010.
 */
@Controller
@RequestMapping(value = "/apiHandler")
public class APIController {
    public final static Logger logger = LoggerFactory.getLogger(APIController.class);
    @Autowired
    private ApiService apiSV;

    /**
     * 获取项目列表
     * @return
     */
    @RequestMapping(value = "/getProjects")
    public String getProjects() {

        return "/index.jsp";
    }
}
