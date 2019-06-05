package com.wms.controller;

import com.wms.UserRoleService;
import com.wms.response.ResponseWrapper;
import com.wms.response.UuId;
import com.wms.user.service.bean.RoleBean;
import com.wms.user.service.bean.UserRoleBean;
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
@RequestMapping("/userRole")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    @RequiresPermissions("userRole:save")
    @PostMapping(value = "save")
    @ApiOperation(value = "用户授权角色")
    public ResponseWrapper save(UserRoleBean userRoleBean, ServletRequest request) {
        setOjb(userRoleBean,request,"save");
        userRoleService.save(userRoleBean);
        return ResponseWrapper.markSuccessSave();
    }

    @RequiresPermissions("userRole:select")
    @GetMapping(value = "list")
    @ApiOperation(value = "查看所有用户授权的角色")
    public ResponseWrapper list() {
        List userRoleBeanList = userRoleService.list();
        return ResponseWrapper.markListSuccess(userRoleBeanList);
    }

    @RequiresPermissions("userRole:select")
    @GetMapping(value = "getByid")
    @ApiOperation(value = "根据ID查看用户授权的角色")
    public ResponseWrapper getByid(String id) {
        if (id == null || id.equals("")) {
            return ResponseWrapper.markParamError("ID 不能为空");
        }
        UserRoleBean userRoleBean = userRoleService.getByid(id);
        return ResponseWrapper.markSuccess(userRoleBean);
    }

    @RequiresPermissions("userRole:update")
    @PostMapping(value = "update")
    @ApiOperation(value = "修改用户授权的角色")
    public ResponseWrapper update(UserRoleBean userRoleBean, ServletRequest request) {
        setOjb(userRoleBean,request,"update");
        userRoleService.update(userRoleBean);
        return ResponseWrapper.markSuccessUpdate();
    }

    @RequiresPermissions("userRole:delete")
    @PostMapping(value = "delete")
    @ApiOperation(value = "删除用户授权的角色")
    public ResponseWrapper delete(String id) {
        userRoleService.delete(id);
        return ResponseWrapper.markSuccessDelete();
    }
    private void setOjb(UserRoleBean userRoleBean, ServletRequest request, String mag) {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("Token");
        String userName = JwtUtil.getUsername(token);
        String userId = JwtUtil.getUserId(token);
        if (mag.equals("save")) {
            userRoleBean.setId(UuId.getUUID());
            userRoleBean.setCreator(userId);
            userRoleBean.setCreatePerson(userName);
            userRoleBean.setCreateTime(new Date());
        } else if (mag.equals("update")) {
            userRoleBean.setEditor(userId);
            userRoleBean.setModifyPerson(userName);
            userRoleBean.setModifyTime(new Date());
        }
    }
}
