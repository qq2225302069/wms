package com.wms.service.impl;

import com.wms.RolePermissionService;
import com.wms.mapper.RolePermissionMapper;
import com.wms.user.service.bean.RolePermissionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    public String save(RolePermissionBean rolePermissionBean) {
             rolePermissionMapper.save(rolePermissionBean);
            return "添加成功";
    }
    public String update(RolePermissionBean rolePermissionBean){
        rolePermissionMapper.update(rolePermissionBean);
        return "修改成功";
    }

    public List<RolePermissionBean> list(){
        return rolePermissionMapper.list(null);
    }

    public RolePermissionBean getByid(String id){
        return rolePermissionMapper.getById(id);
    }

    public String delete(String id){
        rolePermissionMapper.delete(id);
        return "删除成功";
    }
}
