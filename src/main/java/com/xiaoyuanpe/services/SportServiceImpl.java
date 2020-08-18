package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.SportsMapper;
import com.xiaoyuanpe.pojo.Sports;
import com.xiaoyuanpe.pojo.SportsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportServiceImpl implements SportService {
    @Autowired
    private SportsMapper sportsMapper;

    @Override
    public void addSports(Sports sports) {
        this.sportsMapper.insert(sports);
    }

    @Override
    public List<Sports> findSportsAll() {
        SportsExample sportsExample = new SportsExample();
        return this.sportsMapper.selectByExample(sportsExample);
    }

    @Override
    public Sports findSportsById(Integer id) {
        return this.sportsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void ModifySports(Sports sports) {
        this.sportsMapper.updateByPrimaryKey(sports);
    }

    @Override
    public void DeleteSports(Integer id) {
        this.sportsMapper.deleteByPrimaryKey(id);
    }
}
