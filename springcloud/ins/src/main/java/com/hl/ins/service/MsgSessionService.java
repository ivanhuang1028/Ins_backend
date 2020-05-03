package com.hl.ins.service;

import com.hl.ins.mapper.MsgSessionMapper;
import com.hl.ins.vo.msg.MsgsUsersVO;

import java.util.List;

public interface MsgSessionService<T> extends BaseService<T>, MsgSessionMapper<T> {

    List<MsgsUsersVO> msgsusers(String user_id);

    void updateUserIds(String userIds);
}
