package com.xiaoyuanpe.services.impl;

import com.xiaoyuanpe.mapper.UserSportMapper;
import com.xiaoyuanpe.pojo.UserSport;
import com.xiaoyuanpe.pojo.UserSportExample;
import com.xiaoyuanpe.services.UserSportService;
import com.xiaoyuanpe.units.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserSportServiceImpl implements UserSportService {

    @Resource
    private UserSportMapper userSportMapper;

    @Override
    public void addUserSport(UserSport userSport) {
        this.userSportMapper.insert(userSport);
    }

    @Override
    public Pager<UserSport> findUserSportAll(Integer current, Integer pageSize) {
        UserSportExample userSportExample = new UserSportExample();
        List<UserSport> userSports = this.userSportMapper.selectByExample(userSportExample);
        int totalNum = (int) this.userSportMapper.countByExample(userSportExample);
        Pager<UserSport> pager = new Pager<>();
        pager.setCurrentPage(current);
        pager.setPageSize(pageSize);
        pager.setRecordTotal(totalNum);
        if (current * pageSize < totalNum) {
            pager.setContent(userSports.subList((current - 1) * pageSize, current * pageSize));
        } else {
            if ((current - 1) * pageSize <= totalNum) {
                pager.setContent(userSports.subList((current - 1) * pageSize, totalNum));
            } else {
                pager.setContent(null);
            }

        }
        return pager;
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

    @Override
    public void DeleteUserSportList(List<Integer> ids) {
        this.userSportMapper.deleteByPrimaryKeys(ids);
    }
}
