package com.wms.controller;

import com.wms.UserService;
import com.wms.response.ResponseWrapper;
import com.wms.response.UuId;
import com.wms.user.service.bean.UserBean;
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
@Api(tags = "UserController", description = "用户")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequiresPermissions("user:save")
    @PostMapping(value = "save")
    @ApiOperation(value = "添加用户")
    public ResponseWrapper save(UserBean userBean, String roleId, ServletRequest request) {
        setOjb(userBean, request, "save");
        userService.save(userBean, roleId);
        return ResponseWrapper.markSuccessSave();
    }

    @RequiresPermissions("user:select")
    @GetMapping(value = "list")
    @ApiOperation(value = "查看所有用户")
    public ResponseWrapper list() {
        List userList = userService.list();
        return ResponseWrapper.markListSuccess(userList);
    }

    @RequiresPermissions("user:select")
    @GetMapping(value = "getByid")
    @ApiOperation(value = "根据ID查看用户信息")
    public ResponseWrapper getByid(String id) {
        if (id == null || id.equals("")) {
            return ResponseWrapper.markParamError("ID 不能为空");
        }
        UserBean userBean = userService.getByid(id);
        return ResponseWrapper.markSuccess(userBean);
    }

    @RequiresPermissions("user:update")
    @PostMapping(value = "update")
    @ApiOperation(value = "修改用户信息")
    public ResponseWrapper update(UserBean userBean, ServletRequest request) {
        setOjb(userBean, request, "update");
        userService.update(userBean);
        return ResponseWrapper.markSuccessUpdate();
    }

    @RequiresPermissions("user:delete")
    @PostMapping(value = "delete")
    @ApiOperation(value = "删除用户")
    public ResponseWrapper delete(String id) {
        userService.delete(id);
        return ResponseWrapper.markSuccessDelete();
    }

    private void setOjb(UserBean userBean, ServletRequest request, String mag) {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("Token");
        String userName = JwtUtil.getUsername(token);
        String userId = JwtUtil.getUserId(token);
        if (mag.equals("save")) {
            userBean.setId(UuId.getUUID());
            userBean.setCreator(userId);
            userBean.setCreatePerson(userName);
            userBean.setCreateTime(new Date());
        } else if (mag.equals("update")) {
            userBean.setEditor(userId);
            userBean.setModifyPerson(userName);
            userBean.setModifyTime(new Date());
        }
    }

}
