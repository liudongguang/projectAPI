package com.ldg.api.service;

import com.ldg.api.po.TProjectapis;
import com.ldg.api.vo.controllerparam.InitApiTitleData;
import com.ldg.api.vo.jstree.JsTreeData;

import java.util.List;

/**
 * Created by liudo on 2017/4/1.
 */
public interface JsTreeService {
    /**
     * 获取接口信息
     * @return
     */
    List<TProjectapis> getApiTitlesData(Integer projectid);

    /**
     * 保存根节点

     * @return
     */
    int saveRootMenu(InitApiTitleData param);

    /**
     * 保存树数据信息
     * @param saveData
     * @return
     */
    int saveApiTitleData(List<JsTreeData> saveData);

    /**
     * 添加节点返回id
     * @param ele
     * @return
     */
    Integer createTreeElement(TProjectapis ele);

    /**
     * 删除节点
     * @param uid
     * @return
     */
    Integer deleteTreeElement(Integer uid);

    /**
     * 修改接口名称
     * @param ele
     * @return
     */
    Integer updateTreeElement(TProjectapis ele);
}
