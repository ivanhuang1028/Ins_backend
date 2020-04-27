package com.hl.ins.controller;

import com.hl.common.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import javax.servlet.http.HttpServletRequest;

/**
 * 所有的Controller类需要继承此类
 *
 * @author ivan.huang
 */
@Slf4j
public abstract class BaseController {

    /**
     * 获取登录者的用户标识
     *
     * @param request
     * @return
     */
//    public String getLoginerId(HttpServletRequest request) {
//        return ((User) request.getAttribute(Constants.LOGINERKEY)).getUser_id();
//    }


    /**
     * 获取登录者的英文名
     *
     * @param request
     * @return
     */
//    public String getLoginerEname(HttpServletRequest request) {
//        return getLoginer(request).getUser_ename();
//    }

    /**
     * 获取登录者信息
     *
     * @param request
     * @return
     */
//    public User getLoginer(HttpServletRequest request) {
//        return (User) request.getAttribute(Constants.LOGINERKEY);
//    }

    /**
     * 获取登录者的JWT信息
     *
     * @param request
     * @return
     */
    public String getAuthorization(HttpServletRequest request) {
        return (String) request.getAttribute(Constants.AUTHORIZATION);
    }
}
