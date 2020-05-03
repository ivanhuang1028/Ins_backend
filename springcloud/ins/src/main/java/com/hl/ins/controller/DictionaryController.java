package com.hl.ins.controller;

import com.github.pagehelper.PageHelper;
import com.hl.common.constants.Result;
import com.hl.common.constants.ResultCode;
import com.hl.common.util.UUIDGenerator;
import com.hl.ins.module.Dictionary;
import com.hl.ins.service.DictionaryService;
import com.hl.ins.util.Constants;
import com.hl.ins.vo.dic.DicVO;
import com.hl.ins.vo.msg.MsgsUsersVO;
import com.hl.ins.vo.page.PageVO;
import com.hl.ins.vo.page.ResultsPageVO;
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
@RestController("dictionaryController")
@Scope("prototype")
public class DictionaryController extends BaseController {

    @Autowired
    private DictionaryService<Dictionary> dictionaryService;

    /**
     * 发现 1. 标签列表接口
     * @return
     */
    @RequestMapping(value = "/dics/label", method = RequestMethod.GET)
    public Result insertAction(HttpServletRequest request, PageVO pageVO) {
        List<DicVO> dicVO = new ArrayList<>();
        if(pageVO.getOpenPage()){
            PageHelper.startPage(pageVO.getPageIndex(), pageVO.getPageSize());
        }

        dicVO = dictionaryService.queryByName(Constants.DIC_LABEL);
        ResultsPageVO resultsPageVO = ResultsPageVO.init(dicVO, pageVO);
        return Result.getSuccResult(resultsPageVO);
    }

}

