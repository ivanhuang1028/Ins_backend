package com.hl.ins.controller;

import com.github.pagehelper.PageHelper;
import com.hl.common.constants.Result;
import com.hl.common.constants.ResultCode;
import com.hl.ins.module.Dictionary;
import com.hl.ins.module.User;
import com.hl.ins.service.DictionaryService;
import com.hl.ins.service.UserService;
import com.hl.ins.vo.dic.DicVO;
import com.hl.ins.vo.page.PageVO;
import com.hl.ins.vo.page.ResultsPageVO;
import com.hl.ins.vo.user.UserInfoVO;
import com.hl.ins.vo.user.UserVO;
import com.hl.ins.vo.userfocus.UserFocusTosVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@RestController("userController")
@Scope("prototype")
public class UserController extends BaseController {

    @Autowired
    private UserService<User> userService;

    @Autowired
    private DictionaryService<Dictionary> dictionaryService;

    /**
     * 发现 4. 热门搜索用户列表接口
     * @return
     */
    @RequestMapping(value = "/users/hot", method = RequestMethod.GET)
    public Result focusTos(HttpServletRequest request, PageVO pageVO, String key){
        List<UserVO> userVO = new ArrayList<>();
        // 分页
        if(pageVO.getOpenPage()){
            PageHelper.startPage(pageVO.getPageIndex(), pageVO.getPageSize());
        }
        userVO = userService.focusTos(getLoginerId(request), key);
        ResultsPageVO resultsPageVO = ResultsPageVO.init(userVO, pageVO);
        return Result.getSuccResult(resultsPageVO);
    }

    /**
     * 发现 5. 搜索用户列表接口
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Result users(HttpServletRequest request, PageVO pageVO, String key){
        List<UserVO> userVO = new ArrayList<>();
        // 分页
        if(pageVO.getOpenPage()){
            PageHelper.startPage(pageVO.getPageIndex(), pageVO.getPageSize());
        }
        userVO = userService.users(getLoginerId(request), key);
        ResultsPageVO resultsPageVO = ResultsPageVO.init(userVO, pageVO);
        return Result.getSuccResult(resultsPageVO);
    }

    /**
     * 发现 6. 标签搜索用户列表接口
     * @return
     */
    @RequestMapping(value = "/users/label", method = RequestMethod.GET)
    public Result usersLabel(HttpServletRequest request, PageVO pageVO, String label_ids){
        List<UserVO> userVO = new ArrayList<>();
        // 分页
        if(pageVO.getOpenPage()){
            PageHelper.startPage(pageVO.getPageIndex(), pageVO.getPageSize());
        }
        List<String> labelIds = Arrays.asList(label_ids.split(","));
        userVO = userService.usersLabel(getLoginerId(request), labelIds);
        ResultsPageVO resultsPageVO = ResultsPageVO.init(userVO, pageVO);
        return Result.getSuccResult(resultsPageVO);
    }

    /**
     * 发现 7. 地点搜索用户列表接口
     * @return
     */
    @RequestMapping(value = "/users/region", method = RequestMethod.GET)
    public Result usersRegion(HttpServletRequest request, PageVO pageVO, String key){
        List<UserVO> userVO = new ArrayList<>();
        // 分页
        if(pageVO.getOpenPage()){
            PageHelper.startPage(pageVO.getPageIndex(), pageVO.getPageSize());
        }
        userVO = userService.usersRegion(getLoginerId(request), key);
        ResultsPageVO resultsPageVO = ResultsPageVO.init(userVO, pageVO);
        return Result.getSuccResult(resultsPageVO);
    }

    /**
     * 个人主页 1. 查询个人简介接口
     * @return
     */
    @RequestMapping(value = "/users/info/{user_id}", method = RequestMethod.GET)
    public Result usersInfo(HttpServletRequest request, @PathVariable("user_id") String user_id){
        if(StringUtils.isEmpty(user_id)){
            return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 user_id");
        }
        UserInfoVO userInfoVO = userService.usersInfo(user_id);

        List<DicVO> labels = dictionaryService.queryUserLabels(user_id);
        StringBuffer user_labels = new StringBuffer();
        for(DicVO vo : labels){
            if(StringUtils.isEmpty(user_labels.toString())){
                user_labels.append(vo.getDic_value());
            }else{
                user_labels.append(",").append(vo.getDic_value());
            }
        }
        userInfoVO.setUser_labels(user_labels.toString());

        return Result.getSuccResult(userInfoVO);
    }

}

