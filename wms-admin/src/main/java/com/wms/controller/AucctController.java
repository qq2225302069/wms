package com.wms.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wms.dto.ExceptionEnum;
import com.wms.dto.ResponseData;
import com.wms.service.AucctService;
import com.wms.util.JwtUtil;
import com.wms.util.MyMD5Util;
import com.wms.vo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cyh on 2019/3/26.
 */
@RestController
public class AucctController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private AucctService userService;

    @RequestMapping(value = "/login")
    public ResponseData login(User user) {

        ResponseData responseData = null;
        try {
            if (user==null || user.getUsername()==null){
                responseData = new ResponseData(ExceptionEnum._500.getCode(), "请输入用户名");
            }
            else if (user==null || user.getPassword()==null){
                responseData = new ResponseData(ExceptionEnum._500.getCode(), "请输入密码");
            }else{
                User u = userService.getUserWordByUserName(user.getUsername());
                String pass = MyMD5Util.encrypt(user.getPassword());

                if(u.getPassword()==null){
                    responseData = new ResponseData(ExceptionEnum._500.getCode(), "该用户不存在");
                }
                else if (pass.equals(u.getPassword())) {
                    responseData = new ResponseData(ExceptionEnum._200.getCode(), "登录成功", u, JwtUtil.createToken(user.getUsername(),u.getId()));
                }else{

                    responseData = new ResponseData(ExceptionEnum._500.getCode(), "密码错误");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseData = new ResponseData(ExceptionEnum._500.getCode(), "登录失败");
        }
        return responseData;
    }

    @RequestMapping(value = "/logout")
    public ResponseData logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();//退出
        return new ResponseData(ExceptionEnum._200.getCode(), "退出成功");
    }

    @RequestMapping(value = "/unauth")
    public ResponseData unauth() {
        return new ResponseData(ExceptionEnum._505.getCode(), "未登录");
    }

    @RequiresPermissions("permission:select")
    @RequestMapping(value = "/userdelete")
    public ResponseData userDelete() {
        return new ResponseData(ExceptionEnum._200.getCode(), "删除成功");
    }

    @RequiresRoles("admin")
    @RequestMapping(value = "/userupdate")
    public ResponseData userupdate() {
        return new ResponseData(ExceptionEnum._200.getCode(), "修改成功");
    }

}
