package com.hl.ins.mapper;

import com.hl.ins.vo.usercollect.UserCollectVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ivan.huang
 */
@Mapper
public interface UserCollectMapper<T> extends BaseMapper<T> {

    List<UserCollectVO> collects(@Param("loginerId") String loginerId);

}
