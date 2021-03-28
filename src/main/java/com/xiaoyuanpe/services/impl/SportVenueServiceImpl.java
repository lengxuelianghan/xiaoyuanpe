package com.xiaoyuanpe.services.impl;

import com.xiaoyuanpe.mapper.SportvenueMapper;
import com.xiaoyuanpe.pojo.Sportvenue;
import com.xiaoyuanpe.pojo.SportvenueExample;
import com.xiaoyuanpe.services.SportVenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SportVenueServiceImpl implements SportVenueService {
    @Resource
    private SportvenueMapper sportvenueMapper;

    @Override
    public void addSportvenue(Sportvenue sportvenue) {
        this.sportvenueMapper.insert(sportvenue);
    }

    @Override
    public List<Sportvenue> findSportvenueAll() {
        return this.sportvenueMapper.selectByExample(new SportvenueExample());
    }

    @Override
    public Sportvenue findSportvenueById(Integer id) {
        return this.sportvenueMapper.selectByPrimaryKey(id);
    }

    @Override
    public void ModifySportvenue(Sportvenue sportvenue) {
        this.sportvenueMapper.updateByPrimaryKey(sportvenue);
    }

    @Override
    public void DeleteSportvenue(Integer id) {

    }

    @Override
    public void DeleteSportvenueList(List<Integer> ids) {
        for (Integer id : ids) {
            this.sportvenueMapper.deleteByPrimaryKey(id);
        }
    }
}
