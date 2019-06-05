package com.wms.service.impl;

import com.wms.PermissionService;
import com.wms.mapper.PermissionMapper;
import com.wms.user.service.bean.PermissionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;
    public String save(PermissionBean permissionBean) {
            permissionMapper.save(permissionBean);
            return "添加成功";
    }
    public String update(PermissionBean permissionBean){
            permissionMapper.update(permissionBean);
            return "修改成功";

    }

    public List<PermissionBean> list(){
        return permissionMapper.list(null);
    }

    public PermissionBean getByid(String id){
        return permissionMapper.getById(id);
    }

    public String delete(String id){
        permissionMapper.delete(id);
        return "删除成功";
    }
}
