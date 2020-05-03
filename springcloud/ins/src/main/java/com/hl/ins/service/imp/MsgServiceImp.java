package com.hl.ins.service.imp;

import com.hl.ins.mapper.BaseMapper;
import com.hl.ins.mapper.MsgMapper;
import com.hl.ins.service.MsgService;
import com.hl.ins.vo.msg.MsgVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

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


    @Override
    public List<MsgVO> hisMess(String loginerId, String msg_user_id, String history_msg_time) {
        return getMapper().hisMess(loginerId, msg_user_id, history_msg_time);
    }

    @Override
    public List<MsgVO> newMess(String loginerId, String msg_user_id, String new_msg_time) {
        return getMapper().newMess(loginerId, msg_user_id, new_msg_time);
    }

    @Override
    public void updateMsgRead(String loginerId, String msg_user_id) {
        getMapper().updateMsgRead(loginerId, msg_user_id);
    }
}
