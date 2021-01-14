package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.StudentMapper;
import com.xiaoyuanpe.mapper.UserMapper;
import com.xiaoyuanpe.pojo.Permissions;
import com.xiaoyuanpe.pojo.Student;
import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.pojo.UserExample;
import com.xiaoyuanpe.units.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper usersMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void addUser(User users) {
//        Student student = new Student();
//        student.setStudentNumber(users.getUserNumber());
//        student.setStudentName(users.getUsername());
//        student.setSchoolId(users.getSchoolId());
//        this.studentMapper.insert(student);
        this.usersMapper.insert(users);
    }

    @Override
    public Pager<User> findUsersAll(Integer current, Integer pageSize) {
        Pager<User> pager = new Pager<>();
        pager.setCurrentPage(current);
        pager.setPageSize(pageSize);
        UserExample example = new UserExample();
        int totalNum = (int)this.usersMapper.countByExample(example);
        pager.setRecordTotal(totalNum);
        List<User> userList = this.usersMapper.selectByExample(example);
        if (current * pageSize < totalNum) {
            pager.setContent(userList.subList((current - 1) * pageSize, current * pageSize));
        }
        else {
            if ((current - 1) * pageSize <= totalNum){
                pager.setContent(userList.subList((current - 1) * pageSize, totalNum));
            }
            else {
                pager.setContent(null);
            }

        }
        return pager;
    }

    @Override
    public List<User> findUsersListAll() {
        return this.usersMapper.selectByExample(new UserExample());
    }

    @Override
    public User findUsersById(Integer id) {
        return this.usersMapper.selectByPrimaryKey(id);
    }

    @Override
    public User findUsersByStudentNum(String num) {
        return this.usersMapper.selectByStudentNum(num);
    }

    @Override
    public User findUsersByStudentNumAndSchool(String num, Integer id) {
        return this.usersMapper.selectByStudentNumAndSchool(num, id);
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
    public void DeleteUserList(List<Integer> ids) {
        this.usersMapper.deleteByPrimaryKeys(ids);
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

    @Override
    public long Count() {
        return this.usersMapper.countByExample(new UserExample());
    }

    @Override
    public User findRolesByUsername(String userNumber) {
        return this.usersMapper.findRolesByUsername(userNumber);
    }

    @Override
    public List<Permissions> findPermsByRoleId(Integer id) {
        return this.usersMapper.findPermsByRoleId(id);
    }

    @Override
    public void addBatch(List<User> list) {
        this.usersMapper.insertBatch(list);
    }
}
