package com.hl.ins.service;

import com.hl.ins.mapper.MsgMapper;
import com.hl.ins.vo.msg.MsgVO;
import com.hl.ins.vo.msg.MsgsUsersVO;

import java.util.List;

public interface MsgService<T> extends BaseService<T>, MsgMapper<T> {

    List<MsgVO> hisMess(String loginerId, String msg_user_id, String history_msg_time);

    List<MsgVO> newMess(String loginerId, String msg_user_id, String new_msg_time);

    void updateMsgRead(String loginerId, String msg_user_id);
}
