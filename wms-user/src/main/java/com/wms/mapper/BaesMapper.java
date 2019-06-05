package com.wms.mapper;

import com.wms.user.service.bean.RoleBean;

import java.util.List;
import java.util.Map;

public interface BaesMapper<T> {
    void save(T t);

    void update(T t);

    void delete(String id);

    List<T> list(Map<String, Object> map);

    T getById(String id);
}
