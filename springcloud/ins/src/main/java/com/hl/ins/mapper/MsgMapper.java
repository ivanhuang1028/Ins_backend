package com.hl.ins.mapper;

import com.hl.ins.vo.msg.MsgActionVO;
import com.hl.ins.vo.msg.MsgVO;
import com.hl.ins.vo.msg.MsgsUsersVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ivan.huang
 */
@Mapper
public interface MsgMapper<T> extends BaseMapper<T> {

    List<MsgVO> hisMess(@Param("loginerId") String loginerId, @Param("msg_user_id") String msg_user_id, @Param("history_msg_time") String history_msg_time);

    List<MsgVO> newMess(@Param("loginerId") String loginerId, @Param("msg_user_id")String msg_user_id, @Param("new_msg_time") String new_msg_time);

    void updateMsgRead(@Param("loginerId") String loginerId, @Param("msg_user_id") String msg_user_id);

    List<MsgActionVO> msgsAction(@Param("loginerId") String loginerId);

    List<MsgActionVO> msgsAction1(@Param("loginerId") String loginerId);

    List<MsgActionVO> msgsAction2(@Param("loginerId") String loginerId);

    List<MsgActionVO> msgsAction3(@Param("loginerId") String loginerId);

    List<MsgActionVO> msgsAction4(@Param("loginerId") String loginerId);

}
