package com.wms;

import com.wms.user.service.bean.RoleBean;
import com.wms.user.service.bean.UserBean;

import java.util.List;

public interface UserService {
    String save(UserBean userBean,String roleId);

    List<UserBean> list();

    String update(UserBean userBean);

    String delete(String id);

    UserBean getByid(String id);
}
