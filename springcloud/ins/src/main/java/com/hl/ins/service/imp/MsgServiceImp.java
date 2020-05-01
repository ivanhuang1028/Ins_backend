package com.hl.ins.service.imp;

import com.hl.ins.mapper.BaseMapper;
import com.hl.ins.mapper.MsgMapper;
import com.hl.ins.service.MsgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("msgService")
public class MsgServiceImp<T> extends BaseServiceImp<T> implements MsgService<T> {

    @Override
    public MsgMapper<T> getMapper() {
        return (MsgMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("msgMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
