package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Sports;

import java.util.List;

public interface SportService {
    void addSports(Sports sports);

    List<Sports> findSportsAll();

    Sports findSportsById(Integer id);

    void ModifySports(Sports sports);

    void DeleteSports(Integer id);
}
