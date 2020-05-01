package com.hl.ins.module;

import lombok.Data;

import java.io.Serializable;

/**
 * 帖子标签
 * @author ivan.huang
 */
@Data
public class TopicLabel implements Serializable {

    //帖子标识
    private String topic_id;

    //标签标识
    private String dic_id;

}