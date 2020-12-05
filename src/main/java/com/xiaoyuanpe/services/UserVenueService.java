package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.UserVenue;

import java.util.List;

public interface UserVenueService {
    void addUserVenue(UserVenue userVenue);

    List<UserVenue> findUserVenueAll();

    UserVenue findUserVenueById(Integer id);

    void ModifyUserVenue(UserVenue userVenue);

    void DeleteUserVenue(Integer id);

    void DeleteUserVenueList(List<Integer> ids);
}
