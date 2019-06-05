package com.wms;

import com.wms.user.service.bean.UserRoleBean;

import java.util.List;

public interface UserRoleService {

    String save(UserRoleBean userBean);

    List<UserRoleBean> list();

    String update(UserRoleBean userBean);

    String delete(String id);

    UserRoleBean getByid(String id);
}
