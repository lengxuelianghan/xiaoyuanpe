package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Space;

import java.util.List;

public interface SpaceService {
    void addSpace(Space space);

    List<Space> findSpaceAll();

    Space findSpaceById(Integer id);

    List<Space> findSpaceBySportId(Integer id);

    void ModifySpace(Space space);

    void DeleteSpace(Integer id);

    void DeleteSpaceList(List<Integer> ids);
}
