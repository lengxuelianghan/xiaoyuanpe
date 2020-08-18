package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.SportInfoMapper;
import com.xiaoyuanpe.pojo.SportInfo;
import com.xiaoyuanpe.pojo.SportInfoExample;
import com.xiaoyuanpe.pojo.SportsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportInfoServiceImpl implements SportInfoService {
    @Autowired
    private SportInfoMapper sportInfoMapper;

    @Override
    public void addSportInfo(SportInfo sportInfo) {
        this.sportInfoMapper.insert(sportInfo);
    }

    @Override
    public List<SportInfo> findSportInfoAll() {
        SportInfoExample sportsExample = new SportInfoExample();
        return this.sportInfoMapper.selectByExample(sportsExample);
    }

    @Override
    public SportInfo findSportInfoById(Integer id) {
        return this.sportInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void ModifySportInfo(SportInfo school) {
        this.sportInfoMapper.updateByPrimaryKey(school);
    }

    @Override
    public void DeleteSportInfo(Integer id) {
        this.sportInfoMapper.deleteByPrimaryKey(id);
    }
}
