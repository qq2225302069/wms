package com.wms.service.impl;

import com.wms.UserService;
import com.wms.mapper.UserMapper;
import com.wms.mapper.UserRoleMapper;
import com.wms.response.UuId;
import com.wms.user.service.bean.UserBean;
import com.wms.user.service.bean.UserRoleBean;
import com.wms.util.MyMD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;


//    @Transactional
    public String save(UserBean userBean, String roleId) {

        String pass = MyMD5Util.encrypt(userBean.getPassword());
        userBean.setPassword(pass);
        userMapper.save(userBean);


        UserRoleBean userRoleBean = new UserRoleBean();
        userRoleBean.setId(UuId.getUUID());
        userRoleBean.setUserId(userBean.getId());
        userRoleBean.setRoleId(roleId);
        userRoleBean.setCreator(userBean.getCreator());
        userRoleBean.setCreatePerson(userBean.getCreatePerson());
        userRoleBean.setCreateTime(userBean.getCreateTime());
        userRoleMapper.save(userRoleBean);


        return "添加成功";
    }

    public String update(UserBean userBean) {
        userMapper.update(userBean);
        return "修改成功";
    }

    public List<UserBean> list() {
        return userMapper.list(null);
    }

    public UserBean getByid(String id) {
        return userMapper.getById(id);
    }

    public String delete(String id) {
        userMapper.delete(id);
        return "删除成功";
    }
}
