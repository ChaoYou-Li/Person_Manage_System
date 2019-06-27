package cn.zdxh.personnelmanage.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 */


public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 拦截之前调用
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //没有登录
        if (session.getAttribute("admin")  == null){
            //跳回到登录页面
            response.sendRedirect("/login/index");
            session.setAttribute("msg","您还没登录哦~");
            return false;
        }
        //否则放行
        return true;
    }
}
