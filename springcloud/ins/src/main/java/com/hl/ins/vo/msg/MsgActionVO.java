package com.hl.ins.vo.msg;

import lombok.Data;

@Data
public class MsgActionVO {

    private String user_id;
    private String user_name;
    private String user_icon;
    private Integer action_type;
    private String topic_id;

}
