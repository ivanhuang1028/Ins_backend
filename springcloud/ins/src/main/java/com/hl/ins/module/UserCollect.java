package com.hl.ins.module;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ivan.huang
 */
@Data
public class UserCollect implements Serializable {

    //收藏帖子的用户标识
    private String user_id;

    //帖子标识
    private String topic_id;

    //收藏时间
    private String collecttime;

}