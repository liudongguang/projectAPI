package com.ldg.controller;

import com.ldg.api.po.TProjectapis;
import com.ldg.api.service.JsTreeService;
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
@RequestMapping(value = "/jsTree")
public class JsTreeController {
    public final static Logger logger = LoggerFactory.getLogger(JsTreeController.class);
    @Autowired
    private JsTreeService jsTreeService;


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
        List<TProjectapis> list=jsTreeService.getApiTitlesData(projectid);
        if(list.size()==0){
            msg.setErrcode(1);
            msg.setErrmsg("需要初始化列表");
            return msg;
        }
        List<JsTree> treeList = new ArrayList<>();
        list.forEach((item)->{
            JsTree treeElement = new JsTree();
            treeElement.setId(String.valueOf(item.getUid()));
            treeElement.setParent(item.getParentid());//关联的父级id
            treeElement.setText(item.getApititle());
            treeElement.getState().setOpened(true);
            treeElement.getLi_attr().setLevel(item.getLevel());  //节点深度
            treeElement.getLi_attr().setProjectid(item.getProjectid()); //关联的项目id
            treeList.add(treeElement);
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
    public ResultMsg saveApiTitleData(HttpServletRequest request,@RequestBody List<JsTreeData> saveData) {
        ResultMsg msg=new ResultMsg();
        int i=jsTreeService.saveApiTitleData(saveData);
        return msg;
    }

    /**
     * 初始化列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/initApiTitleData")
    @ResponseBody
    public ResultMsg initApiTitleData(HttpServletRequest request,Integer projectid) {
        ResultMsg msg=new ResultMsg();
        int i=jsTreeService.saveRootMenu(projectid);
        return msg;
    }

    /**
     * 创建节点
     * @param request
     * @param ele
     * @return
     */
    @RequestMapping(value = "/createTreeElement")
    @ResponseBody
    public ResultMsg createTreeElement(HttpServletRequest request,TProjectapis ele) {
        ResultMsg msg=new ResultMsg();
        System.out.println(ele);
        Integer addID=jsTreeService.createTreeElement(ele);
        msg.setData(addID);
        return msg;
    }

    /**
     * 删除节点
     * @param request
     * @param uid
     * @return
     */
    @RequestMapping(value = "/deleteTreeElement")
    @ResponseBody
    public ResultMsg deleteTreeElement(HttpServletRequest request,Integer uid) {
        ResultMsg msg=new ResultMsg();
        Integer delnum=jsTreeService.deleteTreeElement(uid);
        return msg;
    }


    @RequestMapping(value = "/updateTreeElement")
    @ResponseBody
    public ResultMsg updateTreeElement(HttpServletRequest request,TProjectapis ele) {
        ResultMsg msg=new ResultMsg();
        Integer delnum=jsTreeService.updateTreeElement(ele);
        return msg;
    }

}
