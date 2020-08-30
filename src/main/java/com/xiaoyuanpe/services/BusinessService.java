package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Business;
import com.xiaoyuanpe.units.Pager;

import java.util.List;

public interface BusinessService {
    void addBusiness(Business business);

    Pager<Business> findBusinessAll(int current, int pageSize);

    Business findBusinessById(Integer id);

    void ModifyBusiness(Business business);

    void DeleteBusiness(Integer id);

    long Count();
}
