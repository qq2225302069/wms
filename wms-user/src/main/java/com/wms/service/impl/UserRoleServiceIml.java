package com.wms.service.impl;

import com.wms.UserRoleService;
import com.wms.mapper.UserRoleMapper;
import com.wms.user.service.bean.UserRoleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceIml implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;
    public String save(UserRoleBean userRoleBean) {
            userRoleMapper.save(userRoleBean);

            return "添加成功";
    }
    public String update(UserRoleBean userRoleBean){
            userRoleMapper.update(userRoleBean);
            return "修改成功";
    }

    public List<UserRoleBean> list(){
        return userRoleMapper.list(null);
    }

    public UserRoleBean getByid(String id){
        return userRoleMapper.getById(id);
    }

    public String delete(String id){
        userRoleMapper.delete(id);
        return "删除成功";
    }
}
