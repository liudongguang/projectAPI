package com.ldg.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldg.api.po.TProjectapis;
import com.ldg.api.po.TProjects;
import com.ldg.api.service.ApiService;
import com.ldg.api.vo.PageParam;
import com.ldg.api.vo.jstree.JsTreeData;
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
    private TProjectapisMapper projectapisDao;

    @Autowired
    private TProjectsMapper projectsDao;

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
    public List<TProjectapis> getApiTitlesData(Integer projectid) {
        return projectapisDao.getApiTitlesDataByProjectId(projectid);
    }

    @Override
    public int saveRootMenu(Integer projectid) {
        TProjectapis pp=new TProjectapis();
        pp.setParentid("#");
        pp.setApititle("-----项目接口-----");
        pp.setProjectid(projectid);
        pp.setLevel(0);
        return projectapisDao.insertSelective(pp);
    }

    @Override
    public int saveApiTitleData(List<JsTreeData> saveData) {
        System.out.println(saveData);
        JsTreeData root=saveData.get(0);
        root.getChildren().forEach((item)->{
            TProjectapis pp=new TProjectapis();
            pp.setParentid(root.getId());
            pp.setApititle(item.getText());
            pp.setProjectid(item.getLi_attr().getProjectid());
            pp.setLevel(item.getLi_attr().getLevel());
            projectapisDao.insertSelective(pp);
            item.getChildren().forEach((item2)->{
                TProjectapis pp2=new TProjectapis();
                pp2.setParentid(String.valueOf(pp.getUid()));
                pp2.setApititle(item2.getText());
                pp2.setProjectid(item.getLi_attr().getProjectid());
                pp2.setLevel(item2.getLi_attr().getLevel());
               projectapisDao.insertSelective(pp2);
            });
        });
        return 0;
    }
}
