package com.hl.ins.mapper;

import com.hl.ins.vo.msg.MsgsUsersVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ivan.huang
 */
@Mapper
public interface MsgMapper<T> extends BaseMapper<T> {

}
