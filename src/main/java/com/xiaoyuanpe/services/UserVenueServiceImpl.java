package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.UserVenueMapper;
import com.xiaoyuanpe.pojo.UserVenue;
import com.xiaoyuanpe.pojo.UserVenueExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserVenueServiceImpl implements UserVenueService {
    @Autowired
    private UserVenueMapper userVenueMapper;
    @Override
    public void addUserVenue(UserVenue userVenue) {
        this.userVenueMapper.insert(userVenue);
    }

    @Override
    public List<UserVenue> findUserVenueAll() {
        return this.userVenueMapper.selectByExample(new UserVenueExample());
    }

    @Override
    public UserVenue findUserVenueById(Integer id) {
        return this.userVenueMapper.selectByPrimaryKey(id);
    }

    @Override
    public void ModifyUserVenue(UserVenue userVenue) {
        this.userVenueMapper.updateByPrimaryKey(userVenue);
    }

    @Override
    public void DeleteUserVenue(Integer id) {

    }

    @Override
    public void DeleteUserVenueList(List<Integer> ids) {
        for (Integer id: ids){
            this.userVenueMapper.deleteByPrimaryKey(id);
        }
    }
}
