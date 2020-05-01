package com.hl.ins.service;

import com.hl.ins.mapper.UserMapper;

public interface UserService<T> extends BaseService<T>, UserMapper<T> {

}
