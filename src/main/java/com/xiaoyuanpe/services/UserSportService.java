package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.UserSport;

import java.util.List;

public interface UserSportService {
    void addUserSport(UserSport userSport);

    List<UserSport> findUserSportAll();

    UserSport findUserSportById(Integer id);

    void ModifyUserSport(UserSport userSport);

    void DeleteUserSport(Integer id);

}
