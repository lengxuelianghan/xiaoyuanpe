package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.SportInfoMapper;
import com.xiaoyuanpe.pojo.SportInfo;
import com.xiaoyuanpe.pojo.SportInfoExample;
import com.xiaoyuanpe.pojo.SportsExample;
import com.xiaoyuanpe.units.Pager;
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
    public Pager<SportInfo> findSportInfoAll(Integer current, Integer pageSize) {
        SportInfoExample sportsExample = new SportInfoExample();
        List<SportInfo> sportInfos = this.sportInfoMapper.selectByExample(sportsExample);
        int totalNum = (int)this.sportInfoMapper.countByExample(sportsExample);
        Pager<SportInfo> pager = new Pager<>();
        pager.setCurrentPage(current);
        pager.setPageSize(pageSize);
        pager.setRecordTotal(totalNum);
        if (current * pageSize < totalNum) {
            pager.setContent(sportInfos.subList((current - 1) * pageSize, current * pageSize));
        }
        else {
            if ((current - 1) * pageSize <= totalNum){
                pager.setContent(sportInfos.subList((current - 1) * pageSize, totalNum));
            }
            else {
                pager.setContent(null);
            }

        }
        return pager;
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

    @Override
    public void DeleteSportInfoList(List<Integer> ids) {
        this.sportInfoMapper.deleteByPrimaryKeys(ids);
    }
}
