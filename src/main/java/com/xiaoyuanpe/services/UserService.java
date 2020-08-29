package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.units.Pager;

import java.util.List;

public interface UserService {
    void addUser(User users);

    Pager<User> findUsersAll(Integer current, Integer pageSize);

    User findUsersById(Integer id);

    void ModifyUser(User users);

    void DeleteUser(Integer id);

    Boolean NameRepeat(String name);

    long Count();
}
