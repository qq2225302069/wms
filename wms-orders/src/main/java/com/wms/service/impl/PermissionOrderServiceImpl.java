package com.wms.service.impl;

import com.wms.bean.PermissionOrderBean;
import com.wms.mapper.PermissionOrderMapper;
import com.wms.service.PermissionOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionOrderServiceImpl implements PermissionOrderService {

    @Autowired
    private PermissionOrderMapper permissionOrderMapper;
    public String save(PermissionOrderBean permissionOrderBean) {
            permissionOrderMapper.save(permissionOrderBean);
            return "添加成功";
    }
    public String update(PermissionOrderBean permissionOrderBean){
            permissionOrderMapper.update(permissionOrderBean);
            return "修改成功";

    }

    public List<PermissionOrderBean> list(){
        return permissionOrderMapper.list(null);
    }

    public PermissionOrderBean getByid(String id){
        return permissionOrderMapper.getById(id);
    }

    public String delete(String id){
        permissionOrderMapper.delete(id);
        return "删除成功";
    }
}
