package com.hl.ins.controller;

import com.github.pagehelper.PageHelper;
import com.hl.common.constants.Result;
import com.hl.ins.module.User;
import com.hl.ins.service.UserService;
import com.hl.ins.vo.page.PageVO;
import com.hl.ins.vo.page.ResultsPageVO;
import com.hl.ins.vo.user.UserVO;
import com.hl.ins.vo.userfocus.UserFocusTosVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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

}

