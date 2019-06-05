package com.wms;

import com.wms.user.service.bean.PermissionBean;

import java.util.List;

public interface PermissionService {
    String save(PermissionBean permissionBean);

    List<PermissionBean> list();

    String update(PermissionBean permissionBean);

    String delete(String id);

    PermissionBean getByid(String id);
}
