package com.ldg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liudo on 2017/3/10 0010.
 */
@Controller
@RequestMapping(value = "/pajaxReq")
public class PajaxProxyController {
    @RequestMapping(value = "/request")
    public String simple(String pageUrl) {
        return pageUrl;
    }
}
