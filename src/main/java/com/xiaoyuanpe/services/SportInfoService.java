package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.SportInfo;
import com.xiaoyuanpe.units.Pager;

import java.util.List;

public interface SportInfoService {
    void addSportInfo(SportInfo sportInfo);

    Pager<SportInfo> findSportInfoAll(Integer current, Integer pageSize);

    SportInfo findSportInfoById(Integer id);

    void ModifySportInfo(SportInfo school);

    void DeleteSportInfo(Integer id);
    void DeleteSportInfoList(List<Integer> ids);
}
