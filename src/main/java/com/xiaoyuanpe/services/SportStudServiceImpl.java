package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.SportStudMapper;
import com.xiaoyuanpe.pojo.SportStud;
import com.xiaoyuanpe.pojo.SportStudExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SportStudServiceImpl implements SportStudService {
    @Autowired
    private SportStudMapper sportStudMapper;

    @Override
    public void addSportStud(SportStud sportStud) {
        this.sportStudMapper.insert(sportStud);
    }

    @Override
    public SportStud findSportStudById(Integer id) {
        return this.sportStudMapper.selectByPrimaryKey(id);
    }

    @Override
    public void ModifySportStud(SportStud sportStud) {
        this.sportStudMapper.updateByPrimaryKey(sportStud);
    }

    @Override
    public void DeleteSportStudList(List<Integer> ids) {
        ids.forEach(id->{
            this.sportStudMapper.deleteByPrimaryKey(id);
        });
    }

    @Override
    public List<SportStud> findSportStudAllList() {
        return this.sportStudMapper.selectByExample(new SportStudExample());
    }

    @Override
    public SportStud findSportStudByStudentId(Integer id, Integer sportId) {
        return this.sportStudMapper.findSportStudByStudentId(id, sportId);
    }

    @Override
    public void DeleteSportStud(Integer sportId, Integer studentId) {

    }
}
