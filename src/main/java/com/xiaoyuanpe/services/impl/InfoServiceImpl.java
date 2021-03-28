package com.xiaoyuanpe.services.impl;

import com.xiaoyuanpe.mapper.InfoMapper;
import com.xiaoyuanpe.pojo.Info;
import com.xiaoyuanpe.pojo.InfoExample;
import com.xiaoyuanpe.services.InfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {
    @Resource
    private InfoMapper infoMapper;
    @Override
    public void addInfo(Info info) {
        this.infoMapper.insert(info);
    }

    @Override
    public Info findInfoById(Integer id) {
        return infoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void ModifyInfo(Info info) {
        this.infoMapper.updateByPrimaryKey(info);
    }

    @Override
    public void DeleteInfoList(List<Integer> ids) {

    }

    @Override
    public List<Info> findInfoAllList() {
        return this.infoMapper.selectByExample(new InfoExample());
    }
}
