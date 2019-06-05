package com.wms.dto;

import java.util.List;

/**
 * Created by cyh on 2019/3/26.
 */
public class ResponseData {

    private String code;
    private String msg;
    private Object data;
    private String token;

    public ResponseData(){
    }

    public ResponseData(String code,String msg){
        this.code=code;
        this.msg=msg;
    }
    public ResponseData(String code,String msg,Object data){
        this(code,msg);
        this.data=data;
    }
    public ResponseData(String code,String msg,Object data,String token){
        this(code,msg,data);
        this.token=token;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
