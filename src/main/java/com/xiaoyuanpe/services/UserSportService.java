package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.UserSport;
import com.xiaoyuanpe.units.Pager;

import java.util.List;

public interface UserSportService {
    void addUserSport(UserSport userSport);

    Pager<UserSport> findUserSportAll(Integer current, Integer pageSize);

    UserSport findUserSportById(Integer id);

    void ModifyUserSport(UserSport userSport);

    void DeleteUserSport(Integer id);

}
