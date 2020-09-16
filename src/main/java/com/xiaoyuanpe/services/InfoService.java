package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Info;

import java.util.List;

public interface InfoService {
    void addInfo(Info info);

    Info findInfoById(Integer id);

    void ModifyInfo(Info info);

    void DeleteInfoList(List<Integer> ids);

    List<Info>  findInfoAllList();
}
