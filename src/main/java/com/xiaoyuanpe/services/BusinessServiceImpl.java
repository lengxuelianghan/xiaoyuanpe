package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.BusinessMapper;
import com.xiaoyuanpe.pojo.Business;
import com.xiaoyuanpe.pojo.BusinessExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public void addBusiness(Business business) {
        this.businessMapper.insert(business);
    }

    @Override
    public List<Business> findBusinessAll() {
        BusinessExample businessExample = new BusinessExample();
        return this.businessMapper.selectByExample(businessExample);
    }

    @Override
    public Business findBusinessById(Integer id) {
        return this.businessMapper.selectByPrimaryKey(id);
    }

    @Override
    public void ModifyBusiness(Business business) {
        this.businessMapper.updateByPrimaryKey(business);
    }

    @Override
    public void DeleteBusiness(Integer id) {
        this.businessMapper.deleteByPrimaryKey(id);
    }
}
