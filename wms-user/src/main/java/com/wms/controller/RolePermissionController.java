package com.wms.controller;

import com.wms.RolePermissionService;
import com.wms.response.ResponseWrapper;
import com.wms.response.UuId;
import com.wms.user.service.bean.RolePermissionBean;
import com.wms.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@Api(tags = "RolePermissionController", description = "角色权限")
@RequestMapping("/rolePermission")
public class RolePermissionController {
    @Autowired
    private RolePermissionService rolePermissionService;

    @RequiresPermissions("rolePermission:save")
    @PostMapping(value = "save")
    @ApiOperation(value = "添加角色权限")
    public ResponseWrapper save(RolePermissionBean rolePermissionBean, ServletRequest request) {
        setOjb(rolePermissionBean, request, "save");
        rolePermissionService.save(rolePermissionBean);
        return ResponseWrapper.markSuccessSave();
    }

    @RequiresPermissions("rolePermission:select")
    @GetMapping(value = "list")
    @ApiOperation(value = "查看所有角色附有的权限")
    public ResponseWrapper list() {
        List rolePermissionBeanList = rolePermissionService.list();
        return ResponseWrapper.markListSuccess(rolePermissionBeanList);
    }

    @RequiresPermissions("rolePermission:select")
    @GetMapping(value = "getByid")
    @ApiOperation(value = "根据ID查看角色附有的权限")
    public ResponseWrapper getByid(String id) {
        if (id == null || id.equals("")) {
            return ResponseWrapper.markParamError("ID 不能为空");
        }
        RolePermissionBean rolePermissionBean = rolePermissionService.getByid(id);
        return ResponseWrapper.markSuccess(rolePermissionBean);
    }

    @RequiresPermissions("rolePermission:update")
    @PostMapping(value = "update")
    @ApiOperation(value = "修改角色的权限")
    public ResponseWrapper update(RolePermissionBean rolePermissionBean, ServletRequest request) {
        setOjb(rolePermissionBean, request, "update");
        rolePermissionService.update(rolePermissionBean);
        return ResponseWrapper.markSuccessUpdate();
    }

    @RequiresPermissions("rolePermission:delete")
    @PostMapping(value = "delete")
    @ApiOperation(value = "删除角色的权限")
    public ResponseWrapper delete(String id) {
        rolePermissionService.delete(id);
        return ResponseWrapper.markSuccessDelete();
    }

    private void setOjb(RolePermissionBean rolePermissionBean, ServletRequest request, String mag) {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("Token");
        String userName = JwtUtil.getUsername(token);
        String userId = JwtUtil.getUserId(token);
        if (mag.equals("save")) {
            rolePermissionBean.setId(UuId.getUUID());
            rolePermissionBean.setCreator(userId);
            rolePermissionBean.setCreatePerson(userName);
            rolePermissionBean.setCreateTime(new Date());
        } else if (mag.equals("update")) {
            rolePermissionBean.setEditor(userId);
            rolePermissionBean.setModifyPerson(userName);
            rolePermissionBean.setModifyTime(new Date());
        }
    }
}
