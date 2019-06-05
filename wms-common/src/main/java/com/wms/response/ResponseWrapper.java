package com.wms.response;

import java.util.List;

public class ResponseWrapper {

    /**是否成功*/
    private boolean success;
    /**返回码*/
    private String code;
    /**返回信息*/
    private String msg;
    /**返回数据*/
    private Object data;
    /**返回数据*/
    private List<Object> datas;


    /**
     * 自定义返回结果
     * 建议使用统一的返回结果，特殊情况可以使用此方法
     * @param success
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static ResponseWrapper markCustom(boolean success,String code,String msg,String data){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setSuccess(success);
        responseWrapper.setCode(code);
        responseWrapper.setMsg(msg);
        responseWrapper.setData(data);
        return responseWrapper;
    }

    /**
     * 参数为空或者参数格式错误
     * @return
     */
    public static ResponseWrapper markParamError(){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setSuccess(false);
        responseWrapper.setCode(ReturnCode.PARAMS_ERROR.getCode());
        responseWrapper.setMsg(ReturnCode.PARAMS_ERROR.getMsg());
        return responseWrapper;
    }
    public static ResponseWrapper markParamError(String msg){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setSuccess(false);
        responseWrapper.setCode(ReturnCode.PARAMS_ERROR.getCode());
        responseWrapper.setMsg(msg);
        return responseWrapper;
    }


    /**
     * 查询失败
     * @return
     */
    public static ResponseWrapper markError(){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setSuccess(false);
        responseWrapper.setCode(ReturnCode.FEAILED.getCode());
        responseWrapper.setMsg(ReturnCode.FEAILED.getMsg());
        responseWrapper.setData(null);
        return responseWrapper;
    }

    /**
     * 查询成功但无数据
     * @return
     */
    public static ResponseWrapper markSuccessButNoData(){
        ResponseWrapper responseWrapper  = new ResponseWrapper();
        responseWrapper.setSuccess(true);
        responseWrapper.setCode(ReturnCode.NODATA.getCode());
        responseWrapper.setMsg(ReturnCode.NODATA.getMsg());
        responseWrapper.setData(null);
        return responseWrapper;
    }

    /**
     * 添加成功
     * @return
     */
    public static ResponseWrapper markSuccessSave(){
        ResponseWrapper responseWrapper  = new ResponseWrapper();
        responseWrapper.setSuccess(true);
        responseWrapper.setCode(ReturnCode.SAVE.getCode());
        responseWrapper.setMsg(ReturnCode.SAVE.getMsg());
        responseWrapper.setData(null);
        return responseWrapper;
    }

    /**
     * 修改成功
     * @return
     */
    public static ResponseWrapper markSuccessUpdate(){
        ResponseWrapper responseWrapper  = new ResponseWrapper();
        responseWrapper.setSuccess(true);
        responseWrapper.setCode(ReturnCode.UPDATE.getCode());
        responseWrapper.setMsg(ReturnCode.UPDATE.getMsg());
        responseWrapper.setData(null);
        return responseWrapper;
    }

    /**
     * 删除成功
     * @return
     */
    public static ResponseWrapper markSuccessDelete(){
        ResponseWrapper responseWrapper  = new ResponseWrapper();
        responseWrapper.setSuccess(true);
        responseWrapper.setCode(ReturnCode.DELETE.getCode());
        responseWrapper.setMsg(ReturnCode.DELETE.getMsg());
        responseWrapper.setData(null);
        return responseWrapper;
    }

    /**
     * 查询成功且有数据
     * @param data
     * @return
     */
    public static ResponseWrapper markSuccess(Object data){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setSuccess(true);
        responseWrapper.setCode(ReturnCode.SUCCESS.getCode());
        responseWrapper.setMsg(ReturnCode.SUCCESS.getMsg());
        responseWrapper.setData(data);
        return  responseWrapper;
    }
    /**
     * 查询成功且有数据并是数组
     * @param datas
     * @return
     */
    public static ResponseWrapper markListSuccess(List<Object> datas){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setSuccess(true);
        responseWrapper.setCode(ReturnCode.SUCCESS.getCode());
        responseWrapper.setMsg(ReturnCode.SUCCESS.getMsg());
        responseWrapper.setDatas(datas);
        return  responseWrapper;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Object> getDatas() {
        return datas;
    }

    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "ResponseWrapper{" +
                "success=" + success +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", datas='" + datas + '\'' +
                ", data=" + data +
                '}';
    }

}
