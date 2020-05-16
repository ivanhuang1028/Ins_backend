package com.hl.ins.service;

import com.hl.ins.mapper.SysMsgMapper;
import com.hl.ins.module.SysMsg;

public interface SysMsgService<T> extends BaseService<T>, SysMsgMapper<T> {

    Integer sysMsgsCount(String user_id);

    Integer countAll();

    SysMsg getFirst();
}
