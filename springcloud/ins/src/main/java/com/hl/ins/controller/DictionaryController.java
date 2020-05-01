package com.hl.ins.controller;

import com.github.pagehelper.PageHelper;
import com.hl.common.constants.Result;
import com.hl.common.constants.ResultCode;
import com.hl.common.util.UUIDGenerator;
import com.hl.ins.module.Dictionary;
import com.hl.ins.service.DictionaryService;
import com.hl.ins.util.SnowflakeIdWorker;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/dics", method = RequestMethod.POST)
    public Result insertAction(@RequestBody Dictionary dictionary) {
        if(StringUtils.isEmpty(dictionary.getDic_name())){
            return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 dic_name");
        }
        try {
            dictionary.setDic_id(UUIDGenerator.generate());
            dictionaryService.insert(dictionary);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.getFalseResult(ResultCode.FAILURE, e.getMessage());
        }
        return Result.getSuccResult();
    }

    @RequestMapping(value = "/dic/{dic_id}", method = RequestMethod.POST)
    public Result updateAction(@PathVariable("dic_id") String dic_id, Dictionary dic) {
        try {
            dic.setDic_id(dic_id);
            dictionaryService.updateByPrimaryKey(dic);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.getFalseResult(ResultCode.FAILURE, e.getMessage());
        }
        return Result.getSuccResult();
    }

    @RequestMapping(value = "dic/{dic_id}", method = RequestMethod.GET)
    public Result selectByIdAction(@PathVariable("dic_id") String dictionary_id) {
        try {
            return Result.getSuccResult(ResultCode.SUCCESS, "", dictionaryService.selectByPrimaryKey(dictionary_id));
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.getFalseResult(ResultCode.FAILURE, e.getMessage());
        }
    }

    @RequestMapping(value = "/dics/{pageIndex}/{pageSize}", method = RequestMethod.GET)
    public Result queryAction(Dictionary dic, @PathVariable("pageIndex") Integer pageIndex, @PathVariable("pageSize") Integer pageSize) {
        try {
            if (pageIndex > 0 && pageSize > 0) {
                PageHelper.startPage(pageIndex, pageSize);
            }
            return Result.getSuccResult(ResultCode.SUCCESS, "", dictionaryService.selectByBlurryT(dic));
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.getFalseResult(ResultCode.FAILURE, e.getMessage());
        }
    }

    /**
     * 统一字典查询
     * @param dictionary
     */
    @GetMapping("dics")
    public Result dics(Dictionary dictionary) throws Exception {
        List<Dictionary> dictionaries = dictionaryService.selectByBlurryT(dictionary);
        return Result.getSuccessResult(dictionaries);
    }

}

