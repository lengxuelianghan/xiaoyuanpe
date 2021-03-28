package com.xiaoyuanpe.services.impl;

import com.xiaoyuanpe.mapper.IdentitiesMapper;
import com.xiaoyuanpe.mapper.UserMapper;
import com.xiaoyuanpe.pojo.Identities;
import com.xiaoyuanpe.pojo.IdentitiesExample;
import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.services.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IdentityServiceImpl implements IdentityService {
    @Resource
    private IdentitiesMapper identitiesMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public void addIdentities(Identities identities) {
        this.identitiesMapper.insert(identities);
    }

    @Override
    public List<Identities> findIdentitiesAll() {
        IdentitiesExample identitiesExample = new IdentitiesExample();
        return this.identitiesMapper.selectByExample(identitiesExample);
    }

    @Override
    public Identities findIdentitiesById(Integer id) {
        return this.identitiesMapper.selectByPrimaryKey(id);
    }

    @Override
    public void ModifyIdentities(Identities identities) {
        this.identitiesMapper.updateByPrimaryKey(identities);
    }

    @Override
    public void DeleteIdentities(Integer id) {

    }

    @Override
    public void DeleteIdentitiesList(List<Integer> ids) {
        this.identitiesMapper.deleteByPrimaryKeys(ids);
    }

    @Override
    public Identities findIdentitiesByName(String name) {
        return this.identitiesMapper.selectByPrimaryName(name);
    }

    @Override
    public Boolean assignIdentity(Integer id, String name) {
        Boolean b = false;
        User user = this.userMapper.selectByPrimaryKey(id);
        Identities identities = this.identitiesMapper.selectByPrimaryName(name);
        if (user!=null && identities!=null){
            user.setIdentity(identities.getIdentityName());
            this.userMapper.updateByPrimaryKey(user);
            b = true;
        }
        else {
            b = false;
        }
        return b;
    }
}
