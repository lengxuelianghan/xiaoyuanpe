package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.UserMapper;
import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper usersMapper;

    @Override
    public void addUser(User users) {
        this.usersMapper.insert(users);
    }

    @Override
    public List<User> findUsersAll() {
        UserExample example = new UserExample();
        return this.usersMapper.selectByExample(1);
    }

    @Override
    public User findUsersById(Integer id) {
        return this.usersMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void ModifyUser(User users) {
        this.usersMapper.updateByPrimaryKey(users);
    }

    @Override
    public void DeleteUser(Integer id) {
        this.usersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Boolean NameRepeat(String number) {
        User user = this.usersMapper.selectByPrimaryNumber(number);
        if (user!=null){
            return false;
        }
        else {
            return true;
        }
    }
}
