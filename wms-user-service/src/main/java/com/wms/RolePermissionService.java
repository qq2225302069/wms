package com.wms;

import com.wms.user.service.bean.RolePermissionBean;

import java.util.List;

public interface RolePermissionService {
    String save(RolePermissionBean rolePermissionBean);

    List<RolePermissionBean> list();

    String update(RolePermissionBean rolePermissionBean);

    String delete(String id);

    RolePermissionBean getByid(String id);
}
