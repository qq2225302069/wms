package com.wms.mapper;

import com.wms.vo.Permission;
import com.wms.vo.Role;
import com.wms.vo.User;

import java.util.List;

/**
 * Created by cyh on 2019/3/26.
 */
public interface AucctMapper {
    String getPassWordByUserName(String username) ;
    User getUserWordByUserName(String username);
    List<String> getRolesByUsername(String username);
    List<String> getPermissionsByUsername(String username);

    List<Permission> getPermissionsByUserId(String id);
    List<Role> getRolesByUserId(String id);
}
