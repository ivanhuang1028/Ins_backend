package com.hl.ins.service.imp;

import com.hl.ins.mapper.BackendAccountMapper;
import com.hl.ins.mapper.BaseMapper;
import com.hl.ins.service.BackendAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("backendAccountService")
public class BackendAccountServiceImp<T> extends BaseServiceImp<T> implements BackendAccountService<T> {

    @Override
    public BackendAccountMapper<T> getMapper() {
        return (BackendAccountMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("backendAccountMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
