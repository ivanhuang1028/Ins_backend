package com.hl.ins.service.imp;

import com.hl.ins.mapper.BaseMapper;
import com.hl.ins.mapper.UserLabelMapper;
import com.hl.ins.service.UserLabelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("userLabelService")
public class UserLabelServiceImp<T> extends BaseServiceImp<T> implements UserLabelService<T> {

    @Override
    public UserLabelMapper<T> getMapper() {
        return (UserLabelMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("userLabelMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
