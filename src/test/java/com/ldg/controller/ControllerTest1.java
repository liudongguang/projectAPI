package com.ldg.controller;

import com.dbgenerate.controller.DBSourceController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

/**
 * Created by LiuDongguang on 2017/7/14.
 */
public class ControllerTest1 extends TestBase{
    @Autowired
    private DBSourceController dBSourceController;
    @Resource
    WebApplicationContext wac;
    private MockMvc mockMvc;
    private MockMvc mockMvc2;
    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(dBSourceController).build();
        mockMvc2 = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    @Test
    public void Ctest() throws Exception {
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/dbsourceHandler/getDbsourceList"));
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("=====客户端获得反馈数据:" + result);
        System.out.println("=====客户端获得反馈数据request attr :" + mvcResult.getRequest().getAttribute("page"));
        // 也可以从response里面取状态码，header,cookies...
//        System.out.println(mvcResult.getResponse().getStatus());

    }
    @Test
    public void Ctest2() throws Exception {
//        mockMvc2.perform(
//                (MockMvcRequestBuilders.post("/dbsourceHandler/getDbsourceList")
//                        .contentType(MediaType.APPLICATION_JSON).content("")))
//                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
        ResultActions resultActions = this.mockMvc2.perform(MockMvcRequestBuilders.post("/dbsourceHandler/getDbsourceList"));
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("=====客户端获得反馈数据:" + result);
        System.out.println("=====客户端获得反馈数据request attr :" + mvcResult.getRequest().getAttribute("page"));

    }
}
