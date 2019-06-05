package com.wms.dto;

public interface IExceptionEnum {
    /**
     * 获取状态码
     *
     * @return 状态码
     */
    String getCode();

    /**
     * 获取提示信息
     *
     * @return 提示信息
     */
    String getMessage();
}
