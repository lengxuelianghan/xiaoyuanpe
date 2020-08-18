package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Business;

import java.util.List;

public interface BusinessService {
    void addBusiness(Business business);

    List<Business> findBusinessAll();

    Business findBusinessById(Integer id);

    void ModifyBusiness(Business business);

    void DeleteBusiness(Integer id);
}
