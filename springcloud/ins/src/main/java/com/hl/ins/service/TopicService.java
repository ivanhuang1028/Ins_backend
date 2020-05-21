package com.hl.ins.service;

import com.hl.ins.mapper.TopicMapper;
import com.hl.ins.vo.topic.TopicsCommentsVO;
import com.hl.ins.vo.topic.TopicsImagesVO;
import com.hl.ins.vo.topic.TopicsVO;
import com.hl.ins.vo.topic.TopicsVideoVO;

import java.util.List;

public interface TopicService<T> extends BaseService<T>, TopicMapper<T> {

    public List<TopicsVO> topics(String user_id);

    List<TopicsImagesVO> topicsImagesVO(String topic_id);

    Integer countTopicsVideo(String dic_id);

    List<TopicsVideoVO> topicsVideo(Integer ran, Integer video_num, String dic_id);

    Integer countTopicsPic(String dic_id);

    List<TopicsVideoVO> topicsPic(Integer ran, Integer pic_num, String dic_id);

    List<TopicsVO> topicsUserId(String user_id, String loginerId);

    TopicsVO topicsId(String loginerId, String topic_id);

    void topicAtRead(String topic_id, String loginerId);

    List<TopicsCommentsVO> topicsComments(String topic_id);

    List<TopicsVO> recommendTopics(String loginerId, String topic_id);
}
