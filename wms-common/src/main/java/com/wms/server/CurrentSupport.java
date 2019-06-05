package com.wms.server;

import com.wms.exception.ServiceException;

public interface CurrentSupport<T> {

    void fillCurrent(T obj) throws ServiceException;

    void fillCurrentWhenEdit(T obj) throws ServiceException;

}
