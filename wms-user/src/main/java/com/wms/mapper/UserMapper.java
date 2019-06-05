package com.wms.mapper;

import com.wms.user.service.bean.UserBean;

public interface UserMapper extends BaesMapper<UserBean>{

    String listMax();
}
