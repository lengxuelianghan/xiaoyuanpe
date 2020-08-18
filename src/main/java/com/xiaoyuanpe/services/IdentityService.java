package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Identities;

import java.util.List;

public interface IdentityService {
    void addIdentities(Identities identities);

    List<Identities> findIdentitiesAll();

    Identities findIdentitiesById(Integer id);

    void ModifyIdentities(Identities identities);

    void DeleteIdentities(Integer id);

    Identities findIdentitiesByName(String name);

    Boolean assignIdentity(Integer id, String name);
}
