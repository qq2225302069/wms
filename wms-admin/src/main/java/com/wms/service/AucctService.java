package com.wms.service;

import com.wms.vo.User;

import java.util.List;

/**
 * Created by cyh on 2019/3/26.
 */
public interface AucctService {

    String getPassWordByUserName(String username) ;
    User getUserWordByUserName(String username) ;
    List<String> getRolesByUsername(String username);
    List<String> getPermissionsByUsername(String username);


}
