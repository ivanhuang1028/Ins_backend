package com.hl.ins.service.imp;

import com.hl.ins.mapper.BaseMapper;
import com.hl.ins.mapper.TopicCommentMapper;
import com.hl.ins.service.TopicCommentService;
import com.hl.ins.vo.topiccomment.CommentVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("topicCommentService")
public class TopicCommentServiceImp<T> extends BaseServiceImp<T> implements TopicCommentService<T> {

    @Override
    public TopicCommentMapper<T> getMapper() {
        return (TopicCommentMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("topicCommentMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


    @Override
    public List<CommentVO> comments(String topic_id) {
        return getMapper().comments(topic_id);
    }

    @Override
    public void read(String topic_id) {
        getMapper().read(topic_id);
    }
}
