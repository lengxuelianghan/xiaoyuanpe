package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.User;

import java.util.List;

public interface UserService {
    void addUser(User users);

    List<User> findUsersAll();

    User findUsersById(Integer id);

    void ModifyUser(User users);

    void DeleteUser(Integer id);

    Boolean NameRepeat(String name);
}
