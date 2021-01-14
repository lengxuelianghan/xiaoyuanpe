package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Permissions;
import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.units.Pager;

import java.util.List;

public interface UserService {
    void addUser(User users);

    Pager<User> findUsersAll(Integer current, Integer pageSize);

    List<User> findUsersListAll();

    User findUsersById(Integer id);

    User findUsersByStudentNum(String num);

    User findUsersByStudentNumAndSchool(String num, Integer id);

    void ModifyUser(User users);

    void DeleteUser(Integer id);

    void DeleteUserList(List<Integer> ids);

    Boolean NameRepeat(String name);

    long Count();

    User findRolesByUsername(String userNumber);

    List<Permissions> findPermsByRoleId(Integer id);
}
