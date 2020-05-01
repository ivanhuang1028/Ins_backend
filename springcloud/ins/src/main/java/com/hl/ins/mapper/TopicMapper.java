package com.hl.ins.mapper;

import com.hl.ins.vo.topic.TopicsImagesVO;
import com.hl.ins.vo.topic.TopicsVO;
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

}
