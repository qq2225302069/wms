package com.wms.service;

import com.wms.bean.PermissionOrderBean;
import com.wms.user.service.bean.PermissionBean;

import java.util.List;

public interface PermissionOrderService {
    String save(PermissionOrderBean permissionOrderBean);

    List<PermissionOrderBean> list();

    String update(PermissionOrderBean permissionOrderBean);

    String delete(String id);

    PermissionOrderBean getByid(String id);
}
