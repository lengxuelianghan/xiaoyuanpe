package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.SportStud;

import java.util.List;

public interface SportStudService {
    void addSportStud(SportStud sportStud);

    SportStud findSportStudById(Integer id);

    void ModifySportStud(SportStud sportStud);

    void DeleteSportStudList(List<Integer> ids);

    List<SportStud>  findSportStudAllList();

    SportStud findSportStudByStudentId(Integer id);

}
