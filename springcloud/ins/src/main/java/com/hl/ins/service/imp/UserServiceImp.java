package com.hl.ins.service.imp;

import com.hl.ins.mapper.BaseMapper;
import com.hl.ins.mapper.UserMapper;
import com.hl.ins.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("userService")
public class UserServiceImp<T> extends BaseServiceImp<T> implements UserService<T> {

    @Override
    public UserMapper<T> getMapper() {
        return (UserMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("userMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
