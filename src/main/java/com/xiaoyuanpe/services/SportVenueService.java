package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Sportvenue;

import java.util.List;

public interface SportVenueService {
    void addSportvenue(Sportvenue sportvenue);

    List<Sportvenue> findSportvenueAll();

    Sportvenue findSportvenueById(Integer id);

    void ModifySportvenue(Sportvenue sportvenue);

    void DeleteSportvenue(Integer id);

    void DeleteSportvenueList(List<Integer> ids);
}
