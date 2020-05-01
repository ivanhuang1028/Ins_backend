package com.hl.ins.service.imp;

import com.hl.ins.mapper.BaseMapper;
import com.hl.ins.mapper.TopicMapper;
import com.hl.ins.service.TopicService;
import com.hl.ins.vo.topic.TopicsImagesVO;
import com.hl.ins.vo.topic.TopicsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("topicService")
public class TopicServiceImp<T> extends BaseServiceImp<T> implements TopicService<T> {

    @Override
    public TopicMapper<T> getMapper() {
        return (TopicMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("topicMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }

    @Override
    public List<TopicsVO> topics(String user_id) {
        return getMapper().topics(user_id);
    }

    @Override
    public List<TopicsImagesVO> topicsImagesVO(String topic_id) {
        return getMapper().topicsImagesVO(topic_id);
    }
}
