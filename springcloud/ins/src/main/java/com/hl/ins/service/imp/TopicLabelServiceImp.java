package com.hl.ins.service.imp;

import com.hl.ins.mapper.BaseMapper;
import com.hl.ins.mapper.TopicLabelMapper;
import com.hl.ins.service.TopicLabelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("topicLabelService")
public class TopicLabelServiceImp<T> extends BaseServiceImp<T> implements TopicLabelService<T> {

    @Override
    public TopicLabelMapper<T> getMapper() {
        return (TopicLabelMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("topicLabelMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
