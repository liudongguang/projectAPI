package com.ldg.impl.service;

import com.ldg.api.po.TProjectapis;
import com.ldg.api.service.JsTreeService;
import com.ldg.api.vo.controllerparam.InitApiTitleData;
import com.ldg.api.vo.jstree.JsTreeData;
import com.ldg.impl.mapper.TProjectapisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liudo on 2017/4/1.
 */
@Service
public class JsTreeServiceImpl implements JsTreeService {
    @Autowired
    private TProjectapisMapper projectapisDao;

    @Override
    public List<TProjectapis> getApiTitlesData(Integer projectid) {
        return projectapisDao.getApiTitlesDataByProjectId(projectid);
    }

    @Override
    public int saveRootMenu(InitApiTitleData param) {
        TProjectapis pp=new TProjectapis();
        pp.setParentid("#");
        StringBuilder appTitle=new StringBuilder();
        appTitle.append("-----[").append(param.getProjectname()).append("]项目接口-----");
        pp.setApititle(appTitle.toString());
        pp.setProjectid(param.getProjectid());
        pp.setLevel(0);
        return projectapisDao.insertSelective(pp);
    }

    @Override
    public int saveApiTitleData(List<JsTreeData> saveData) {
        JsTreeData root=saveData.get(0);//最顶级的根节点
        root.getChildren().forEach((item)->{
            TProjectapis pp=new TProjectapis();
            pp.setParentid(root.getId());
            pp.setApititle(item.getText());
            pp.setProjectid(item.getLi_attr().getProjectid());
            pp.setLevel(item.getLi_attr().getLevel());
            saveTreeHandler(pp,item.getId());//处理添加
            item.getChildren().forEach((item2)->{
                TProjectapis pp2=new TProjectapis();
                pp2.setParentid(String.valueOf(pp.getUid()));
                pp2.setApititle(item2.getText());
                pp2.setProjectid(item.getLi_attr().getProjectid());
                pp2.setLevel(item2.getLi_attr().getLevel());
                saveTreeHandler(pp2,item2.getId());//处理添加
            });
        });
        return 0;
    }

    /**
     * 保存树的信息
     */
    private Integer saveTreeHandler(TProjectapis pp, String treeID){
        //增加
        if(treeID.startsWith("j")){
            return projectapisDao.insertSelective(pp);
        }else{
            Integer uid=Integer.valueOf(treeID);
            pp.setUid(uid);
            String titleName=projectapisDao.getTitleNameForsaveTreeHandler(uid);
            if(!pp.getApititle().equals(titleName)){
                return projectapisDao.updateTitleNameByPrimaryKey(pp);
            }
        }
        return 0;
    }

    @Override
    public Integer createTreeElement(TProjectapis ele) {
        projectapisDao.insertSelective(ele);
        return ele.getUid();
    }

    @Override
    public Integer deleteTreeElement(Integer uid) {
        return projectapisDao.deleteByPrimaryKey(uid);
    }

    @Override
    public Integer updateTreeElement(TProjectapis ele) {
        return projectapisDao.updateByPrimaryKeySelective(ele);
    }
}
