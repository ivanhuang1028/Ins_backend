package com.hl.ins.service.imp;

import com.hl.ins.mapper.BaseMapper;
import com.hl.ins.mapper.TopicImagesMapper;
import com.hl.ins.service.TopicImagesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("topicImagesService")
public class TopicImagesServiceImp<T> extends BaseServiceImp<T> implements TopicImagesService<T> {

    @Override
    public TopicImagesMapper<T> getMapper() {
        return (TopicImagesMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("topicImagesMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
