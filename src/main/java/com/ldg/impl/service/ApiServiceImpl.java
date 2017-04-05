package com.ldg.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldg.api.po.TApiparams;
import com.ldg.api.po.TProjectapis;
import com.ldg.api.po.TProjects;
import com.ldg.api.service.ApiService;
import com.ldg.api.vo.PageParam;
import com.ldg.api.vo.controllerparam.GetApiInfo;
import com.ldg.api.vo.controllerparam.SaveApiParams;
import com.ldg.impl.mapper.TApiparamsMapper;
import com.ldg.impl.mapper.TProjectapisMapper;
import com.ldg.impl.mapper.TProjectsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by liudo on 2017/3/31.
 */
@Service
public class ApiServiceImpl implements ApiService {
    @Autowired
    private TProjectsMapper projectsDao;
    @Autowired
    private TProjectapisMapper projectapisDao;
    @Autowired
    private TApiparamsMapper tApiparamsDao;
    @Override
    public PageInfo<TProjects> getProjectsPageInfo(PageParam pageParam) {
        PageInfo<TProjects> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> projectsDao.getProjectsPageInfo());
        return pageInfo;
    }

    @Override
    public int saveProject(TProjects project) {
        project.setCreatetime(new Date());
        return projectsDao.insertSelective(project);
    }

    @Override
    public List<TApiparams> getApiParamInfo(GetApiInfo param) {
        return tApiparamsDao.getApiInfo(param);
    }

    @Override
    public int saveApiParams(SaveApiParams param) {
         Integer apiID=param.getApiID();
         Integer projectid=param.getProjectid();
         String formMethod=param.getFormMethod();
         String interfaceURL=param.getInterfaceURL();
         List<String> rquestParam=param.getRquestParam();
         List<String> rquestParamType=param.getRquestParamType();
         List<String> rquestParamBeizhu=param.getRquestParamBeizhu();
         List<Integer> rquestParamUID=param.getRquestParamUID();
         List<Integer> rquestDelParamUID=param.getRquestDelParamUID();

         for(int i=0;i<rquestParam.size();i++){
             TApiparams tp=new TApiparams();
             tp.setApiid(apiID);
             tp.setProjectid(projectid);
             tp.setPtype(1);
             tp.setParamname(rquestParam.get(i));
             tp.setParamtype(rquestParamType.get(i));
             tp.setParambeizhu(rquestParamBeizhu.get(i));
             if(rquestParamUID.get(i)!=-1){
                 tp.setUid(rquestParamUID.get(i));
                 tApiparamsDao.updateByPrimaryKeySelective(tp);
             }else {
                 tApiparamsDao.insertSelective(tp);
             }
         }
         //根据参数id删除
        if(rquestDelParamUID!=null){
            rquestDelParamUID.forEach((item)->{
                tApiparamsDao.deleteByPrimaryKey(item);
            });
        }

         /////////////返回参数
         List<String> responseParam=param.getResponseParam();
         List<String> responseParamType=param.getResponseParamType();
         List<String> responseParamBeizhu=param.getResponseParamBeizhu();
        List<Integer> responseParamUID=param.getResponseParamUID();
        List<Integer> responseDelParamUID=param.getResponseDelParamUID();
        for(int i=0;i<responseParam.size();i++){
            TApiparams tp=new TApiparams();
            tp.setApiid(apiID);
            tp.setProjectid(projectid);
            tp.setPtype(2);
            tp.setParamname(responseParam.get(i));
            tp.setParamtype(responseParamType.get(i));
            tp.setParambeizhu(responseParamBeizhu.get(i));
            if(responseParamUID.get(i)!=-1){
                tp.setUid(responseParamUID.get(i));
                tApiparamsDao.updateByPrimaryKeySelective(tp);
            }else {
                tApiparamsDao.insertSelective(tp);
            }
        }
        //根据参数id删除
        if(responseDelParamUID!=null) {
            responseDelParamUID.forEach((item) -> {
                tApiparamsDao.deleteByPrimaryKey(item);
            });
        }
        TProjectapis objapi=new TProjectapis();
        objapi.setUid(apiID);
        objapi.setProjectid(projectid);
        objapi.setDescription("");
        objapi.setInterfaceurl(interfaceURL);
        objapi.setFormmethod(formMethod);
        return projectapisDao.updateByPrimaryKeySelective(objapi);
    }

    @Override
    public TProjectapis getApiInfo(GetApiInfo param) {
        return projectapisDao.selectByPrimaryKey(param.getApiID());
    }
}
