package com.hl.ins.mapper;

import com.hl.ins.vo.topic.TopicsImagesVO;
import com.hl.ins.vo.topic.TopicsVO;
import com.hl.ins.vo.topic.TopicsVideoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ivan.huang
 */
@Mapper
public interface TopicMapper<T> extends BaseMapper<T> {

    List<TopicsVO> topics(@Param("user_id") String user_id);

    List<TopicsImagesVO> topicsImagesVO(@Param("topic_id") String topic_id);

    Integer countTopicsVideo(@Param("dic_id") String dic_id);

    List<TopicsVideoVO> topicsVideo(@Param("ran")Integer ran, @Param("video_num") Integer video_num, @Param("dic_id") String dic_id);

    Integer countTopicsPic(@Param("dic_id") String dic_id);

    List<TopicsVideoVO> topicsPic(@Param("ran") Integer ran, @Param("pic_num") Integer pic_num, @Param("dic_id") String dic_id);

    List<TopicsVO> topicsUserId(@Param("user_id") String user_id, @Param("loginerId") String loginerId);

    TopicsVO topicsId(@Param("loginerId") String loginerId, @Param("topic_id") String topic_id);
}
