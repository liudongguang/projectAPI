package com.dbgenerate.controller;

import com.dbgenerate.api.bo.LdgTable;
import com.dbgenerate.api.bo.LdgTableInfo;
import com.dbgenerate.api.service.DBSourceService;
import com.dbgenerate.api.po.TDbSource;
import com.github.pagehelper.PageInfo;
import com.ldg.api.constant.CommConstant;
import com.ldg.api.po.TProjectapis;
import com.ldg.api.vo.PageParam;
import com.ldg.api.vo.ResultMsg;
import com.ldg.api.vo.jstree.JsTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liudo on 2017/3/10 0010.
 */
@Controller
@RequestMapping(value = "/dbsourceHandler")
public class DBSourceController {
    public final static Logger logger = LoggerFactory.getLogger(DBSourceController.class);
    @Autowired
    private DBSourceService dbSourceService;

    /**
     * 数据源列表
     *
     * @param request
     * @param pageParam
     * @return
     */
    @RequestMapping(value = "/getDbsourceList")
    public String getDbsourceList(HttpServletRequest request, PageParam pageParam) {
        System.out.println("---------------------");
        PageInfo<TDbSource> projects = dbSourceService.getDbsourceList(pageParam);
        request.setAttribute(CommConstant.PAGE_REQUEST_ATTR, projects);
        return "/dbsorce/source/disdbsources.jsp";
    }
    @RequestMapping(value = "/getDbsourceList2")
    public String getDbsourceList2(HttpServletRequest request, PageParam pageParam) {
        PageInfo<TDbSource> projects = dbSourceService.getDbsourceList(pageParam);
        request.setAttribute(CommConstant.PAGE_REQUEST_ATTR, projects);
        return "/dbsorce/source/disdbsources2.jsp";
    }
    /**
     * 保存数据源
     *
     * @param request
     * @param param
     * @return
     */
    @RequestMapping(value = "/saveSource")
    public String saveSource(HttpServletRequest request, TDbSource param) {
        int i = dbSourceService.saveSource(param);
        return "/dbsourceHandler/getDbsourceList";
    }

    /**
     * 处理数据源信息
     *
     * @param request
     * @param param
     * @return
     */
    @RequestMapping(value = "/getTables")
    public String getTables(HttpServletRequest request, TDbSource param) throws Exception {
        List<LdgTable> tables = dbSourceService.getTables(param);
        request.setAttribute(CommConstant.LIST_REQUEST_ATTR, tables);
        return "/dbsorce/source/tableList.jsp";
    }
    /**
     * 处理数据源信息
     *
     * @param request
     * @param param
     * @return
     */
    @RequestMapping(value = "/getTableInfoByTableName")
    public String getTableInfoByTableName(HttpServletRequest request, TDbSource param,String tableName) throws Exception {
        List<LdgTableInfo> tableInfo = dbSourceService.getTableInfo(param,tableName);
        request.setAttribute(CommConstant.LIST_REQUEST_ATTR, tableInfo);
        return "/dbsorce/source/tableinfo.jsp";
    }
    /**
     * 检查数据源名与数据连接是否重复
     *
     * @param request
     * @param param
     * @return
     */
    @RequestMapping(value = "/checkSourceNameAndlink")
    @ResponseBody
    public ResultMsg checkSourceNameAndlink(HttpServletRequest request, TDbSource param) {
        ResultMsg msg = new ResultMsg();
        String err = dbSourceService.checkSourceNameAndlink(param);
        if (err != null) {
            msg.setErrcode(1);
            msg.setErrmsg(err);
        }
        return msg;
    }

    /**
     * 修改数据源
     *
     * @param request
     * @param param
     * @return
     */
    @RequestMapping(value = "/editDBSource")
    public String editDBSource(HttpServletRequest request, TDbSource param) {
        TDbSource dbSource = dbSourceService.selectSourceByID(param);
        request.setAttribute(CommConstant.OBJ_REQUEST_ATTR, dbSource);
        return "/dbsorce/source/addsource.jsp";
    }

    /**
     * 删除数据源
     *
     * @param request
     * @param param
     * @return
     */
    @RequestMapping(value = "/delDBSource")
    public String delDBSource(HttpServletRequest request, TDbSource param) {
        int delnum = dbSourceService.deleteDBSourceByID(param);
        return "/dbsourceHandler/getDbsourceList";
    }


}
