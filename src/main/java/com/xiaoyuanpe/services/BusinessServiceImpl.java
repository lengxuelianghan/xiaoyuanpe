package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.BusinessMapper;
import com.xiaoyuanpe.pojo.Business;
import com.xiaoyuanpe.pojo.BusinessExample;
import com.xiaoyuanpe.units.Pager;
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
    public Pager<Business> findBusinessAll(int current, int pageSize) {
        BusinessExample businessExample = new BusinessExample();
        List<Business> businesses = this.businessMapper.selectByExample(businessExample);
        Pager<Business> pager = new Pager<>();
        pager.setCurrentPage(current);
        pager.setPageSize(pageSize);
        int totalNum = (int)this.businessMapper.countByExample(businessExample);
        pager.setRecordTotal(totalNum);
        if (current * pageSize < totalNum) {
            pager.setContent(businesses.subList((current - 1) * pageSize, current * pageSize));
        }
        else {
            if ((current - 1) * pageSize <= totalNum){
                pager.setContent(businesses.subList((current - 1) * pageSize, totalNum));
            }
            else {
                pager.setContent(null);
            }

        }
        return pager;
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

    @Override
    public void DeleteBusinessList(List<Integer> ids) {
        this.businessMapper.deleteByPrimaryList(ids);
    }

    @Override
    public long Count() {
        return this.businessMapper.countByExample(new BusinessExample());
    }
}
