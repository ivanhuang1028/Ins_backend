package com.hl.ins.service.imp;

import com.hl.ins.mapper.BaseMapper;
import com.hl.ins.mapper.TopicLikeMapper;
import com.hl.ins.service.TopicLikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("topicLikeService")
public class TopicLikeServiceImp<T> extends BaseServiceImp<T> implements TopicLikeService<T> {

    @Override
    public TopicLikeMapper<T> getMapper() {
        return (TopicLikeMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("topicLikeMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
