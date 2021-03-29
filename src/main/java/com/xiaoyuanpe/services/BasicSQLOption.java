package com.xiaoyuanpe.services;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wan
 * @Date: Created in 17:52 2021/3/28
 * @Description:
 * @Modified By:
 */

@Service
public interface BasicSQLOption<K,V> {

    void createRecord(V data);

    Void updateRecord(V data);

    Void deleteRecord(List<K> ids);

    V findByPrimaryKey(Integer id);

    List<V> findAll();
}
