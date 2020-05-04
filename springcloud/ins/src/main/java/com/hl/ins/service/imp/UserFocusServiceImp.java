package com.hl.ins.service.imp;

import com.hl.ins.mapper.BaseMapper;
import com.hl.ins.mapper.UserFocusMapper;
import com.hl.ins.service.UserFocusService;
import com.hl.ins.vo.userfocus.UserFocusTosVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("userFocusService")
public class UserFocusServiceImp<T> extends BaseServiceImp<T> implements UserFocusService<T> {

    @Override
    public UserFocusMapper<T> getMapper() {
        return (UserFocusMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("userFocusMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }

    @Override
    public List<UserFocusTosVO> focusTos(String focus_from) {
        return getMapper().focusTos(focus_from);
    }

    @Override
    public void read(String user_id, String loginerId) {
        getMapper().read(user_id, loginerId);
    }

    @Override
    public void topicRead(String loginerId, String user_id) {
        getMapper().topicRead(loginerId, user_id);
    }
}
