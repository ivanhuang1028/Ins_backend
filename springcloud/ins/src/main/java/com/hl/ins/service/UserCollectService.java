package com.hl.ins.service;

import com.hl.ins.mapper.UserCollectMapper;
import com.hl.ins.vo.usercollect.UserCollectVO;

import java.util.List;

public interface UserCollectService<T> extends BaseService<T>, UserCollectMapper<T> {

    List<UserCollectVO> collects(String loginerId);
}
