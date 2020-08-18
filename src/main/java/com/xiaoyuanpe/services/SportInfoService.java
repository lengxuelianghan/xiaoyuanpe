package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.SportInfo;

import java.util.List;

public interface SportInfoService {
    void addSportInfo(SportInfo sportInfo);

    List<SportInfo> findSportInfoAll();

    SportInfo findSportInfoById(Integer id);

    void ModifySportInfo(SportInfo school);

    void DeleteSportInfo(Integer id);
}
