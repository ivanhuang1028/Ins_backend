package com.hl.ins.service;

import com.hl.ins.mapper.MsgMapper;
import com.hl.ins.vo.msg.MsgsUsersVO;

import java.util.List;

public interface MsgService<T> extends BaseService<T>, MsgMapper<T> {

}
