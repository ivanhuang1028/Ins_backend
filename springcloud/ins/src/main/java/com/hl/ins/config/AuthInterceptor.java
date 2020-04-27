package com.hl.ins.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UrlPathHelper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * @author ivan.huang
 */
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
    private String[] excludeUrls;
    private String loginUrl;
    private String errorUrl;

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object arg2, Exception arg3)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object obj, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        return true;

//        String clinetIp = getClientIp(request);
//        log.info("client IP : " + clinetIp);
//
//        String macIp = getMacIp(clinetIp);
//        log.info("client mac IP : " + macIp);
//
//        String uri = getURI(request);
//        log.debug("request uri :" + uri);
//
//        if(StringUtils.equals(request.getMethod(), "OPTIONS")){
//            return true;
//        }
//
////      其他接口访问：从http head取出jwt，并解析做验证
//        boolean isValid = true;
//        try {
//            String auth = request.getHeader("Authorization");
//
//            if(StringUtils.isEmpty(auth)){
//                auth=request.getParameter("jwt");
//            }
//
//            if(!StringUtils.isEmpty(auth)){
//                if(auth.contains("Bearer ")){
//                    auth = auth.replace("Bearer ", "");
//                }
//                Claims claims = JwtHelper.parseJWT(auth, encodedkey);
//                String enname = (String)claims.get("enname");
//                String cnname = (String)claims.get("cnname");
//                String userid = (String)claims.get("userid");
//                Date expirationDate = claims.getExpiration();
//                if(DateUtil.compare_date(DateUtil.formatDate(expirationDate, Constants.DATE_PATTERN1),
//                        DateUtil.formatDate(new Date(), Constants.DATE_PATTERN1)) != 1){
//                    isValid = false;
//                }
////                if(!checkValid(enname, cnname, userid)){
////                    isValid = false;
////                }
//            }else{
//                isValid = false;
//            }
//
//            if (isValid == true ) {
//                RequestUtils.getCurrentRequest().setAttribute(Constants.AUTHORIZATION,auth);
//                return true;
//            } else {
//                response.setCharacterEncoding("UTF-8");
//                response.setContentType("application/json;charset=UTF-8");
//                response.getWriter().write(Result.noLoginStr);
//                return false;
//            }
//
//        } catch (Exception e) {
//            log.error("鉴权异常",e);
//            response.setCharacterEncoding("UTF-8");
//            response.setContentType("application/json;charset=UTF-8");
//            response.getWriter().write(Result.noLoginStr);
//            return false;
//        }

    }

    private String getMacIp(String ipAddress) throws SocketException,
            UnknownHostException {
        // TODO Auto-generated method stub
        String str = "";
        String macAddress = "";
        final String LOOPBACK_ADDRESS = "127.0.0.1";
        // 如果为127.0.0.1,则获取本地MAC地址。
        if (LOOPBACK_ADDRESS.equals(ipAddress)) {
            InetAddress inetAddress = InetAddress.getLocalHost();
            // 貌似此方法需要JDK1.6。
            byte[] mac = NetworkInterface.getByInetAddress(inetAddress)
                    .getHardwareAddress();
            // 下面代码是把mac地址拼装成String
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                if (i != 0) {
                    sb.append("-");
                }
                // mac[i] & 0xFF 是为了把byte转化为正整数
                String s = Integer.toHexString(mac[i] & 0xFF);
                sb.append(s.length() == 1 ? 0 + s : s);
            }
            // 把字符串所有小写字母改为大写成为正规的mac地址并返回
            macAddress = sb.toString().trim().toUpperCase();
            return macAddress;
        } else {
            // 获取非本地IP的MAC地址
            try {
                System.out.println(ipAddress);
                Process p = Runtime.getRuntime()
                        .exec("nbtstat -A " + ipAddress);
                System.out.println("===process=="+p);
                InputStreamReader ir = new InputStreamReader(p.getInputStream());

                BufferedReader br = new BufferedReader(ir);

                while ((str = br.readLine()) != null) {
                    if(str.indexOf("MAC")>1){
                        macAddress = str.substring(str.indexOf("MAC")+9, str.length());
                        macAddress = macAddress.trim();
                        System.out.println("macAddress:" + macAddress);
                        break;
                    }
                }
                p.destroy();
                br.close();
                ir.close();
            } catch (IOException ex) {
            }
            return macAddress;
        }
    }

    private String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
            ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
            ip = request.getHeader("Proxy-Client-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
            ip = request.getHeader("WL-Proxy-Client-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
            ip = request.getRemoteAddr();
        return ip;
    }


    private String urlReplace(String beforeUrl) {
        String url = beforeUrl.replace("AAA", "?");
        url = url.replace("BBB", "#");
        url = url.replace("CCC", "&");
        url = url.replace(" ", "%20");
        return url;
    }

    /**
     * 获取系统资源地址
     *
     * @param request
     */
    private String getURI(HttpServletRequest request) {
        UrlPathHelper helper = new UrlPathHelper();
        String uri = helper.getOriginatingRequestUri(request);
        String ctxPath = helper.getOriginatingContextPath(request);
        return uri.replaceFirst(ctxPath, "");
    }

    /**
     * 不需要权限控制URL
     *
     * @param uri
     * @return
     */
    private boolean exclude(String uri) {
        if (excludeUrls != null) {
            for (String exc : excludeUrls) {
                if (exc.equals(uri)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String[] getExcludeUrls() {
        return excludeUrls;
    }

    public void setExcludeUrls(String[] excludeUrls) {
        this.excludeUrls = excludeUrls;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getErrorUrl() {
        return errorUrl;
    }

    public void setErrorUrl(String errorUrl) {
        this.errorUrl = errorUrl;
    }

}
