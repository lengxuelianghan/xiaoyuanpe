package com.xiaoyuanpe.services.impl;

import com.xiaoyuanpe.mapper.SpaceMapper;
import com.xiaoyuanpe.pojo.Space;
import com.xiaoyuanpe.pojo.SpaceExample;
import com.xiaoyuanpe.services.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SpaceServiceImpl implements SpaceService {
    @Resource
    private SpaceMapper spaceMapper;

    @Override
    public void addSpace(Space space) {
        this.spaceMapper.insert(space);
    }

    @Override
    public List<Space> findSpaceAll() {
        return this.spaceMapper.selectByExample(new SpaceExample());
    }

    @Override
    public Space findSpaceById(Integer id) {
        return this.spaceMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Space> findSpaceBySportId(Integer id) {
        List<Space> spaces = this.spaceMapper.selectByExample(new SpaceExample());
        List<Space> spaceList = new ArrayList<>();
        for (Space space : spaces) {
            if (space.getSportvenueId().equals(id)) {
                spaceList.add(space);
            }
        }
        return spaceList;
    }

    @Override
    public void ModifySpace(Space space) {
        this.spaceMapper.updateByPrimaryKey(space);
    }

    @Override
    public void DeleteSpace(Integer id) {

    }

    @Override
    public void DeleteSpaceList(List<Integer> ids) {
        for (Integer id : ids) {
            this.spaceMapper.deleteByPrimaryKey(id);
        }
    }
}
