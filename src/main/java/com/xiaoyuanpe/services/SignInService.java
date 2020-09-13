package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Signin;

import java.util.List;

public interface SignInService {
    void addSignin(Signin signin);

    List<Signin> findSigninAll();

    Signin findSigninById(Integer id);

    void ModifySignin(Signin school);

    void DeleteSignin(Integer id);

    void DeleteSigninList(List<Integer> ids);
}
