package com.wms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wms.RoleService;
import com.wms.mapper.RoleMapper;
import com.wms.user.service.bean.RoleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cyh on 2019/5/22.
 */
@Service(version = "1.0.0",interfaceClass=RoleService.class)

public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;



    @Transactional(rollbackFor = Exception.class)
    public String save(RoleBean roleBean) {
            System.err.println("Sql执行前------------");
        roleMapper.save(roleBean);
        System.err.println("Sql执行后------------");
        if( 1 == 1){
            int i=1/0; //开启一个异常
        }
            return "添加成功";
    }
    public String update(RoleBean roleBean){
            roleMapper.update(roleBean);
            return "修改成功";
    }

    public List<RoleBean> list(){
        return roleMapper.list(null);
    }

    public RoleBean getByid(String id){
        return roleMapper.getById(id);
    }

    public String delete(String id){
        roleMapper.delete(id);
        return "删除成功";
    }

    public List<RoleBean> getRoleByUserId(String userId){
        return roleMapper.getRoleByUserId(userId);
    }

}
