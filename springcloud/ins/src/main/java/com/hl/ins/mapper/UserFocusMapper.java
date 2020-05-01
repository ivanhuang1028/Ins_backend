package com.hl.ins.mapper;

import com.hl.ins.vo.userfocus.UserFocusTosVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author ivan.huang
 */
@Mapper
public interface UserFocusMapper<T> extends BaseMapper<T> {

    List<UserFocusTosVO> focusTos(@Param("focus_from") String focus_from);

}