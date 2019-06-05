package com.wms.mapper;

import com.wms.user.service.bean.RoleBean;

import java.util.List;

public interface RoleMapper extends BaesMapper<RoleBean>{

    List<RoleBean> getRoleByUserId(String userId);
}
