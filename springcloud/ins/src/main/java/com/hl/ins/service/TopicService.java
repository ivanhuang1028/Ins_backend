package com.hl.ins.service;

import com.hl.ins.mapper.TopicMapper;
import com.hl.ins.vo.topic.TopicsImagesVO;
import com.hl.ins.vo.topic.TopicsVO;
import java.util.List;

public interface TopicService<T> extends BaseService<T>, TopicMapper<T> {

    public List<TopicsVO> topics(String user_id);

    List<TopicsImagesVO> topicsImagesVO(String topic_id);
}
