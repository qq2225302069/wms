package com.wms.service.impl;

import com.wms.mapper.AucctMapper;
import com.wms.service.AucctService;
import com.wms.vo.Permission;
import com.wms.vo.Role;
import com.wms.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by cyh on 2019/3/26.
 */
@Service
public class AucctServiceImpl implements AucctService {

    Logger logger = Logger.getLogger(this.getClass().getName());
    @Autowired
    private AucctMapper userDao;
    @Override
    public String getPassWordByUserName(String username) {
        logger.info("getPassWordByUserName");
        return userDao.getPassWordByUserName(username);
    }
    @Override
    public User getUserWordByUserName(String username){
        User user = userDao.getUserWordByUserName(username);
        List<Permission> PermissionsList =userDao.getPermissionsByUserId(String.valueOf(user.getId()));
        List<Role> roleList = userDao.getRolesByUserId(String.valueOf(user.getId()));
        user.setPermissionList(PermissionsList);
        user.setRoleList(roleList);
        return user;
    }

    @Override
    public List<String> getRolesByUsername(String username) {
        logger.info("getRolesByUsername");
        return userDao.getRolesByUsername(username);
    }

    @Override
    public List<String> getPermissionsByUsername(String username) {
        logger.info("getPermissionsByUsername");
        return userDao.getPermissionsByUsername(username);
    }
}
