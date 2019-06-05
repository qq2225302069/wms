package com.wms;

import com.wms.user.service.bean.RoleBean;

import java.util.List;

/**
 * Created by cyh on 2019/5/22.
 */
public interface RoleService {
    String save(RoleBean roleBean);

    List<RoleBean> list();

    String update(RoleBean roleBean);

    String delete(String id);

    RoleBean getByid(String id);

    List<RoleBean> getRoleByUserId(String userId);

}
