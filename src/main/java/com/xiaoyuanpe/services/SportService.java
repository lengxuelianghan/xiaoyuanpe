package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Sports;
import com.xiaoyuanpe.units.Pager;

import java.util.List;

public interface SportService {
    void addSports(Sports sports);

    Pager<Sports> findSportsAll(Integer current, Integer pageSize);

    Sports findSportsById(Integer id);

    void ModifySports(Sports sports);

    void DeleteSports(Integer id);
    void DeleteSportsList(List<Integer> ids);
}
