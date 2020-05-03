package com.hl.ins.service.imp;

import com.hl.ins.mapper.BaseMapper;
import com.hl.ins.mapper.MsgSessionMapper;
import com.hl.ins.service.MsgSessionService;
import com.hl.ins.vo.msg.MsgsUsersVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("msgSessionService")
public class MsgSessionServiceImp<T> extends BaseServiceImp<T> implements MsgSessionService<T> {

    @Override
    public MsgSessionMapper<T> getMapper() {
        return (MsgSessionMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("msgSessionMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


    @Override
    public List<MsgsUsersVO> msgsusers(String user_id) {
        return getMapper().msgsusers(user_id);
    }

    @Override
    public void updateUserIds(String userIds) {
        getMapper().updateUserIds(userIds);
    }
}
