package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.InfoMapper;
import com.xiaoyuanpe.pojo.Info;
import com.xiaoyuanpe.pojo.InfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
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
