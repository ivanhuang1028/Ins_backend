package com.hl.ins.mapper;

import com.hl.ins.vo.topiccomment.CommentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ivan.huang
 */
@Mapper
public interface TopicCommentMapper<T> extends BaseMapper<T> {

    List<CommentVO> comments(@Param("topic_id") String topic_id);

}
