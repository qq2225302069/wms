package com.wms.controller;

import com.wms.bean.PermissionOrderBean;
import com.wms.response.ResponseWrapper;
import com.wms.response.UuId;
import com.wms.service.PermissionOrderService;
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
@Api(tags = "PermissionOrderController", description = "权限")
@RequestMapping("/permissionOrder")
public class PermissionOrderController {
    @Autowired
    private PermissionOrderService permissionOrderService;

    @RequiresPermissions("permission:save")
    @PostMapping(value = "save")
    @ApiOperation(value = "添加权限")
    public ResponseWrapper save(PermissionOrderBean permissionOrderBean, ServletRequest request) {
        setOjb(permissionOrderBean, request, "save");
        permissionOrderService.save(permissionOrderBean);
        return ResponseWrapper.markSuccessSave();
    }

    @RequiresPermissions("permission:select")
    @GetMapping(value = "list")
    @ApiOperation(value = "查询所有权限")
    public ResponseWrapper list() {
        List permissionList = permissionOrderService.list();
        return ResponseWrapper.markListSuccess(permissionList);
    }

    @RequiresPermissions("permission:select")
    @GetMapping(value = "getByid")
    @ApiOperation(value = "根据ID查看权限详情")
    public ResponseWrapper getByid(String id) {
        if (id == null || id.equals("")) {
            return ResponseWrapper.markParamError("ID 不能为空");
        }
        PermissionOrderBean permission = permissionOrderService.getByid(id);
        return ResponseWrapper.markSuccess(permission);
    }

    @RequiresPermissions("permission:update")
    @PostMapping(value = "update")
    @ApiOperation(value = "修改权限")
    public ResponseWrapper update(PermissionOrderBean permissionOrderBean, ServletRequest request) {
        setOjb(permissionOrderBean, request, "update");
        permissionOrderService.update(permissionOrderBean);
        return ResponseWrapper.markSuccessUpdate();
    }

    @RequiresPermissions("permission:delete")
    @PostMapping(value = "delete")
    @ApiOperation(value = "删除权限")
    public ResponseWrapper delete(String id) {
        permissionOrderService.delete(id);
        return ResponseWrapper.markSuccessDelete();
    }

    private void setOjb(PermissionOrderBean permissionOrderBean, ServletRequest request, String mag) {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("Token");
        String userName = JwtUtil.getUsername(token);
        String userId = JwtUtil.getUserId(token);
        if (mag.equals("save")) {
            permissionOrderBean.setId(UuId.getUUID());
            permissionOrderBean.setCreator(userId);
            permissionOrderBean.setCreatePerson(userName);
            permissionOrderBean.setCreateTime(new Date());
        } else if (mag.equals("update")) {
            permissionOrderBean.setEditor(userId);
            permissionOrderBean.setModifyPerson(userName);
            permissionOrderBean.setModifyTime(new Date());
        }
    }
}
