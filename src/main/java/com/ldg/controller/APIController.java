package com.ldg.controller;

import com.github.pagehelper.PageInfo;
import com.ldg.api.constant.CommConstant;
import com.ldg.api.po.TProjectapis;
import com.ldg.api.po.TProjects;
import com.ldg.api.service.ApiService;
import com.ldg.api.vo.MsgResult;
import com.ldg.api.vo.PageParam;
import com.ldg.api.vo.ResultMsg;
import com.ldg.api.vo.jstree.JsTree;
import com.ldg.api.vo.jstree.JsTreeData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
     * 登陆操作
     * @param request
     * @return
     */

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request) {
        return "/apimain/index.jsp";
    }
    /**
     * 获取项目列表
     * @return
     */
    @RequestMapping(value = "/getProjects")
    public String getProjects(HttpServletRequest request, PageParam pageParam) {
        PageInfo<TProjects> projects=apiSV.getProjectsPageInfo(pageParam);
        request.setAttribute(CommConstant.PAGE_REQUEST_ATTR,projects);
        return "/apimain/project/disProjectList.jsp";
    }

    /**
     * 保存项目项
     * @param request
     * @param project
     * @return
     */
    @RequestMapping(value = "/saveProject")
    public String saveProject(HttpServletRequest request,TProjects project) {
        int saveState=apiSV.saveProject(project);
        return "/apiHandler/getProjects";
    }

    /**
     * 进入接口编辑列
     * @param request
     * @return
     */
    @RequestMapping(value = "/getApiTitles")
    public String getApiTitles(HttpServletRequest request) {

        return "/apimain/projectapi/disApiList.jsp";
    }

    /**
     * 获取接口列表数据
     * @param request
     * @return
     */
    @RequestMapping(value = "/getApiTitlesData")
    @ResponseBody
    public ResultMsg getApiTitlesData(HttpServletRequest request,Integer projectid) {
        ResultMsg msg=new ResultMsg();
        List<TProjectapis> list=apiSV.getApiTitlesData(projectid);
        if(list.size()==0){
            msg.setErrorCode(1);
            msg.setErrorMsg("需要初始化列表");
            return msg;
        }
        List<JsTree> treeList = new ArrayList<>();
        list.forEach((item)->{
            JsTree jsRoot = new JsTree();
            jsRoot.setId(String.valueOf(item.getUid()));
            jsRoot.setParent(item.getParentid());//关联的父级id
            jsRoot.setText(item.getApititle());
            jsRoot.getState().setOpened(true);
            treeList.add(jsRoot);
        });
        msg.setData(treeList);
        return msg;
    }

    /**
     * 获取树形结构数据，进行保存
     * @param request
     * @param saveData
     * @return
     */
    @RequestMapping(value = "/saveApiTitleData")
    @ResponseBody
    public MsgResult saveApiTitleData(HttpServletRequest request,@RequestBody List<JsTreeData> saveData) {
        MsgResult msg=new MsgResult();
        System.out.println(saveData);
        return msg;
    }

    /**
     * 初始化列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/initApiTitleData")
    @ResponseBody
    public MsgResult initApiTitleData(HttpServletRequest request,Integer projectid) {
        MsgResult msg=new MsgResult();
        int i=apiSV.saveRootMenu(projectid);
        return msg;
    }

}
