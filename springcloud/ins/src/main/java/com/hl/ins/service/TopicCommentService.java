package com.hl.ins.service;

import com.hl.ins.mapper.TopicCommentMapper;
import com.hl.ins.vo.topiccomment.CommentVO;

import java.util.List;

public interface TopicCommentService<T> extends BaseService<T>, TopicCommentMapper<T> {

    List<CommentVO> comments(String topic_id);
}
