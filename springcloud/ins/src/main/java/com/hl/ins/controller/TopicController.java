package com.hl.ins.controller;

import com.github.pagehelper.PageHelper;
import com.hl.common.constants.Result;
import com.hl.ins.module.Topic;
import com.hl.ins.module.UserFocus;
import com.hl.ins.service.TopicService;
import com.hl.ins.service.UserFocusService;
import com.hl.ins.vo.page.PageVO;
import com.hl.ins.vo.page.ResultsPageVO;
import com.hl.ins.vo.topic.TopicsVO;
import com.hl.ins.vo.userfocus.UserFocusTosVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@RestController("topicController")
@Scope("prototype")
public class TopicController extends BaseController {

    @Autowired
    private TopicService<Topic> topicService;

    /**
     * 首页 2. 关注人帖子列表/推荐帖子列表接口
     * 当topic_id为空时，返回被关注人帖子列表
     * 当topic_id不为空时，返回推荐帖子列表，且topic_id对应的帖子排在第一个
     * @return
     */
    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    public Result topics(HttpServletRequest request, PageVO pageVO, String topic_id){
        log.info("关注人帖子列表/推荐帖子列表接口   开始..");
        List<TopicsVO> topicsVO = new ArrayList<>();
        // 分页
        if(pageVO.getOpenPage()){
            PageHelper.startPage(pageVO.getPageIndex(), pageVO.getPageSize());
        }
        if(StringUtils.isEmpty(topic_id)){
            topicsVO = topicService.topics(getLoginerId(request));
        }

        for(TopicsVO vo : topicsVO){
            vo.setImages(topicService.topicsImagesVO(vo.getTopic_id()));
        }

        ResultsPageVO resultsPageVO = ResultsPageVO.init(topicsVO, pageVO);
        log.info("关注人帖子列表/推荐帖子列表接口   结束..");
        return Result.getSuccResult(resultsPageVO);
    }

}

