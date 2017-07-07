package com.dbgenerate.impl.service;

import com.dbgenerate.api.service.DBSourceService;
import com.dbgenerate.api.po.TDbSource;
import com.dbgenerate.impl.mapper.TDbSourceMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldg.api.vo.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by LiuDongguang on 2017/7/7.
 */
@Service
public class DBSourceServiceImpl implements DBSourceService {
    @Autowired
    private TDbSourceMapper tDbSourceMapper;

    @Override
    public PageInfo<TDbSource> getDbsourceList(PageParam pageParam) {
        PageInfo<TDbSource> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> tDbSourceMapper.selectAll());
        return pageInfo;
    }

    @Override
    public int saveSource(TDbSource param) {
        if (param.getUid() == null) {
            param.setCreatetime(new Date());
        } else {
            return tDbSourceMapper.updateByPrimaryKeySelective(param);
        }
        return tDbSourceMapper.insertSelective(param);
    }

    @Override
    public TDbSource handlerDBSource(TDbSource param) {
        return tDbSourceMapper.selectByPrimaryKey(param.getUid());
    }

    @Override
    public String checkSourceNameAndlink(TDbSource param) {
        Integer uid = tDbSourceMapper.selectUIDBySourceName(param);
        if (uid != null) {
            return "重复的数据源名！";
        } else {
            uid = tDbSourceMapper.selectUIDBySourceLink(param);
            if (uid != null) {
                return "重复的连接地址！";
            }
        }

        return null;
    }
}
