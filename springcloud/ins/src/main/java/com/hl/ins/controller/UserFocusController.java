package com.hl.ins.controller;

import com.github.pagehelper.PageHelper;
import com.hl.common.constants.Result;
import com.hl.common.constants.ResultCode;
import com.hl.ins.module.Dictionary;
import com.hl.ins.module.UserFocus;
import com.hl.ins.service.UserFocusService;
import com.hl.ins.vo.page.PageVO;
import com.hl.ins.vo.page.ResultsPageVO;
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
@RestController("userFocusController")
@Scope("prototype")
public class UserFocusController extends BaseController {

    @Autowired
    private UserFocusService<UserFocus> userFocusService;

    /**
     * 首页 1. 被关注人列表接口
     * @return
     */
    @RequestMapping(value = "/focus_tos", method = RequestMethod.GET)
    public Result focusTos(HttpServletRequest request, PageVO pageVO){
        List<UserFocusTosVO> userFocusTosVOList = new ArrayList<>();
        // 分页
        if(pageVO.getOpenPage()){
            PageHelper.startPage(pageVO.getPageIndex(), pageVO.getPageSize());
        }
        userFocusTosVOList = userFocusService.focusTos(getLoginerId(request));
        ResultsPageVO resultsPageVO = ResultsPageVO.init(userFocusTosVOList, pageVO);
        return Result.getSuccResult(resultsPageVO);
    }

}

