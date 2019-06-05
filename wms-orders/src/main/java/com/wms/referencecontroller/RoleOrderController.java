package com.wms.referencecontroller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wms.RoleService;
import com.wms.response.ResponseWrapper;
import com.wms.response.UuId;
import com.wms.user.service.bean.RoleBean;
import com.wms.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by cyh on 2019/5/22.
 */
@RestController
@Api(tags = "RoleOrderController", description = "角色")
@RequestMapping("/roleOrder")
public class RoleOrderController {

    @Reference(version = "1.0.0")
    private RoleService roleService;


    @RequiresPermissions("role:save")
    @PostMapping(value = "save")
    @ApiOperation(value = "添加角色")
    public ResponseWrapper save(RoleBean roleBean, ServletRequest request) {
        setOjb(roleBean, request, "save");
        System.err.println(roleBean.toString() + "添加角色。。。");
        roleService.save(roleBean);
//        if (i == null || i.equals("")) {
//            return ResponseWrapper.markParamError("添加失败");
//        }
        return ResponseWrapper.markSuccessSave();
    }

    @RequiresPermissions("role:select")
    @GetMapping(value = "list")
    @ApiOperation(value = "查看所有角色")
    public ResponseWrapper list() {
        List roleList = roleService.list();
        return ResponseWrapper.markListSuccess(roleList);
    }

    @RequiresPermissions("role:select")
    @GetMapping(value = "getByid")
    @ApiOperation(value = "根据ID查看角色")
    public ResponseWrapper getByid(String id) {
        if (id == null || id.equals("")) {
            return ResponseWrapper.markParamError("ID 不能为空");
        }
        RoleBean roleBean = roleService.getByid(id);
        return ResponseWrapper.markSuccess(roleBean);
    }

    @RequiresPermissions("role:update")
    @PostMapping(value = "update")
    @ApiOperation(value = "修改角色")
    public ResponseWrapper update(RoleBean roleBean, ServletRequest request) {
        setOjb(roleBean, request, "update");
        roleService.update(roleBean);
        return ResponseWrapper.markSuccessUpdate();
    }

    @RequiresPermissions("role:delete")
    @PostMapping(value = "delete")
    @ApiOperation(value = "删除角色")
    public ResponseWrapper delete(String id) {
        roleService.delete(id);
        return ResponseWrapper.markSuccessDelete();
    }

    private void setOjb(RoleBean roleBean, ServletRequest request, String mag) {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("Token");
        String userName = JwtUtil.getUsername(token);
        String userId = JwtUtil.getUserId(token);
        if (mag.equals("save")) {
            roleBean.setId(UuId.getUUID());
            roleBean.setCreator(userId);
            roleBean.setCreatePerson(userName);
            roleBean.setCreateTime(new Date());
        } else if (mag.equals("update")) {
            roleBean.setEditor(userId);
            roleBean.setModifyPerson(userName);
            roleBean.setModifyTime(new Date());
        }
    }

}
