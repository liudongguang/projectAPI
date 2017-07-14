package com.dbgenerate.controller;

import com.dbgenerate.api.bo.LdgTable;
import com.dbgenerate.api.bo.LdgTableInfo;
import com.dbgenerate.api.po.TDbSource;
import com.dbgenerate.api.service.DBSourceService;
import com.github.pagehelper.PageInfo;
import com.ldg.api.constant.CommConstant;
import com.ldg.api.util.HttpClientUtil;
import com.ldg.api.vo.PageParam;
import com.ldg.api.vo.ResultMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by liudo on 2017/3/10 0010.
 */
@Controller
@RequestMapping(value = "/pajaxHandler")
public class PajaxController {
    public final static Logger logger = LoggerFactory.getLogger(PajaxController.class);
    @Autowired
    private DBSourceService dbSourceService;

    @RequestMapping(value = "/test")
    public String test(HttpServletRequest request) {

        return "/pajaxB.jsp";
    }




}
