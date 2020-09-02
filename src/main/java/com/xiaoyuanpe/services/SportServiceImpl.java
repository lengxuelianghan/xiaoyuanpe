package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.SportsMapper;
import com.xiaoyuanpe.pojo.Sports;
import com.xiaoyuanpe.pojo.SportsExample;
import com.xiaoyuanpe.units.Pager;
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
    public Pager<Sports> findSportsAll(Integer current, Integer pageSize) {
        SportsExample sportsExample = new SportsExample();
        List<Sports> sportsList = this.sportsMapper.selectByExample(sportsExample);
        int totalNum = (int)this.sportsMapper.countByExample(sportsExample);
        Pager<Sports> pager = new Pager<>();
        pager.setCurrentPage(current);
        pager.setPageSize(pageSize);
        pager.setRecordTotal(totalNum);
        if (current * pageSize < totalNum) {
            pager.setContent(sportsList.subList((current - 1) * pageSize, current * pageSize));
        }
        else {
            if ((current - 1) * pageSize <= totalNum){
                pager.setContent(sportsList.subList((current - 1) * pageSize, totalNum));
            }
            else {
                pager.setContent(null);
            }

        }
        return pager;
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

    @Override
    public void DeleteSportsList(List<Integer> ids) {
        this.sportsMapper.deleteByPrimaryKeys(ids);
    }
}
