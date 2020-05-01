package com.hl.ins.controller;

import com.github.pagehelper.PageHelper;
import com.hl.common.constants.Result;
import com.hl.common.constants.ResultCode;
import com.hl.ins.module.TopicComment;
import com.hl.ins.service.TopicCommentService;
import com.hl.ins.vo.page.PageVO;
import com.hl.ins.vo.page.ResultsPageVO;
import com.hl.ins.vo.topiccomment.CommentVO;
import com.hl.ins.vo.userfocus.UserFocusTosVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@RestController("topicCommentController")
@Scope("prototype")
public class TopicCommentController extends BaseController {

    @Autowired
    private TopicCommentService<TopicComment> topicCommentService;

    /**
     * 首页 7. 帖子评论列表接口
     * @return
     */
    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public Result comments(HttpServletRequest request, PageVO pageVO, String topic_id){
        if(StringUtils.isEmpty(topic_id)){
            return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 topic_id");
        }
        List<CommentVO> commentVO = new ArrayList<>();
        // 分页
        if(pageVO.getOpenPage()){
            PageHelper.startPage(pageVO.getPageIndex(), pageVO.getPageSize());
        }

        commentVO = topicCommentService.comments(topic_id);
        ResultsPageVO resultsPageVO = ResultsPageVO.init(commentVO, pageVO);
        return Result.getSuccResult(resultsPageVO);
    }

}

