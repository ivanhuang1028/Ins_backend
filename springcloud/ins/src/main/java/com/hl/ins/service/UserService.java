package com.hl.ins.service;

import com.hl.ins.mapper.UserMapper;
import com.hl.ins.vo.user.UserVO;

import java.util.List;

public interface UserService<T> extends BaseService<T>, UserMapper<T> {

    Integer isBefore(String logierId, String user_id);

    List<UserVO> focusTos(String loginerId, String key);

    List<UserVO> users(String loginerId, String key);

    List<UserVO> usersLabel(String loginerId, List<String> labelIds);

    List<UserVO> usersRegion(String loginerId, String key);
}
