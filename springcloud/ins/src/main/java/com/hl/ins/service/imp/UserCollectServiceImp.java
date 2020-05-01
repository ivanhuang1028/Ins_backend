package com.hl.ins.service.imp;

import com.hl.ins.mapper.BaseMapper;
import com.hl.ins.mapper.UserCollectMapper;
import com.hl.ins.service.UserCollectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("userCollectService")
public class UserCollectServiceImp<T> extends BaseServiceImp<T> implements UserCollectService<T> {

    @Override
    public UserCollectMapper<T> getMapper() {
        return (UserCollectMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("userCollectMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
