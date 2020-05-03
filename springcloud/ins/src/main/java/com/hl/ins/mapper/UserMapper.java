package com.hl.ins.mapper;

import com.hl.ins.vo.user.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ivan.huang
 */
@Mapper
public interface UserMapper<T> extends BaseMapper<T> {

    Integer isBefore(@Param("logierId") String logierId, @Param("user_id") String user_id);

    List<UserVO> focusTos(@Param("logierId") String logierId, @Param("key") String key);

    List<UserVO> users(@Param("logierId") String logierId, @Param("key") String key);

    List<UserVO> usersLabel(@Param("logierId") String logierId, @Param("labelIds") List<String> labelIds);

    List<UserVO> usersRegion(@Param("logierId") String loginerId, @Param("key") String key);

}
