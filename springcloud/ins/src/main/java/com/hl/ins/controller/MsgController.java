package com.hl.ins.controller;

import com.github.pagehelper.PageHelper;
import com.hl.common.constants.Result;
import com.hl.common.constants.ResultCode;
import com.hl.common.util.DateUtil;
import com.hl.common.util.DateUtils;
import com.hl.common.util.UUIDGenerator;
import com.hl.ins.module.Msg;
import com.hl.ins.module.MsgSession;
import com.hl.ins.module.TopicLike;
import com.hl.ins.module.User;
import com.hl.ins.service.MsgService;
import com.hl.ins.service.MsgSessionService;
import com.hl.ins.service.UserService;
import com.hl.ins.util.Constants;
import com.hl.ins.vo.msg.MsgsUsersVO;
import com.hl.ins.vo.page.PageVO;
import com.hl.ins.vo.page.ResultsPageVO;
import com.hl.ins.vo.topiccomment.CommentVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author ivan.huang
 */
@Slf4j
@RestController("msgController")
@Scope("prototype")
public class MsgController extends BaseController {

    @Autowired
    private MsgService<Msg> msgService;

    @Autowired
    private MsgSessionService<MsgSession> msgSessionService;

    @Autowired
    private UserService<User> userService;

    /**
     * 首页 9. 帖子转发操作接口
     */
    @RequestMapping(value = "/msgs/topic", method = RequestMethod.POST)
    public Result likes(HttpServletRequest request, @RequestBody HashMap<String, String> paramMap) {
        try {
            if(StringUtils.isEmpty(paramMap.get("topic_id"))){
                return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 topic_id");
            }
            if(StringUtils.isEmpty(paramMap.get("user_ids"))){
                return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 user_ids");
            }

            String logierId = getLoginerId(request);
            List<String> user_ids = Arrays.asList(paramMap.get("user_ids").split(","));
            for (String user_id : user_ids){
                Msg msg = new Msg();
                msg.setMsg_id(UUIDGenerator.generate());
                msg.setUser_from(logierId);
                msg.setUser_to(user_id);
                msg.setMsg_type(Constants.MSG_TYPE_TOPIC);
                msg.setTopic_id(paramMap.get("topic_id"));
                msg.setMsg_time(new Date(System.currentTimeMillis()));
                msgService.insert(msg);

                if(!StringUtils.isEmpty(paramMap.get("msg_content"))){
                    Msg msgChar = new Msg();
                    msgChar.setMsg_id(UUIDGenerator.generate());
                    msgChar.setUser_from(logierId);
                    msgChar.setUser_to(user_id);
                    msgChar.setMsg_type(Constants.MSG_TYPE_CHARACTER);
                    msgChar.setMsg_content(paramMap.get("msg_content"));
                    msgChar.setMsg_time(new Date(System.currentTimeMillis()));
                    msgService.insert(msgChar);
                }

                //更新会话时间
                String userIds = getUserIds(logierId, user_id);
                MsgSession msTmp = new MsgSession();
                msTmp.setUser_ids(userIds);
                if(msgSessionService.selectByEqualT(msTmp) == null){
                    MsgSession ms = new MsgSession();
                    ms.setMs_id(UUIDGenerator.generate());
                    ms.setUser_ids(userIds);
                    ms.setSession_time(new Date(System.currentTimeMillis()));
                    msgSessionService.insert(ms);
                }else{
                    msgSessionService.updateUserIds(userIds);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.getFalseResult(ResultCode.FAILURE, e.getMessage());
        }
        return Result.getSuccResult();
    }

    private String getUserIds(String logierId, String user_id) throws Exception{
        Integer is_before = userService.isBefore(logierId, user_id);
        if(is_before > 0){
            return logierId + "," + user_id;
        }else {
            return user_id + "," + logierId;
        }
    }


}

