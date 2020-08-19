package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.UserSportMapper;
import com.xiaoyuanpe.pojo.UserSport;
import com.xiaoyuanpe.pojo.UserSportExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSportServiceImpl implements UserSportService {
    @Autowired
    private UserSportMapper userSportMapper;
    @Override
    public void addUserSport(UserSport userSport) {
        this.userSportMapper.insert(userSport);
    }

    @Override
    public List<UserSport> findUserSportAll() {
        UserSportExample userSportExample = new UserSportExample();
        return this.userSportMapper.selectByExample(userSportExample);
    }

    @Override
    public UserSport findUserSportById(Integer id) {
        return this.userSportMapper.selectByPrimaryKey(id);
    }

    @Override
    public void ModifyUserSport(UserSport userSport) {
        this.userSportMapper.updateByPrimaryKey(userSport);
    }

    @Override
    public void DeleteUserSport(Integer id) {

    }
}
