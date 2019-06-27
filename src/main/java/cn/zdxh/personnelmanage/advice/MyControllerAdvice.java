package cn.zdxh.personnelmanage.advice;


import cn.zdxh.personnelmanage.exception.MyException;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


    /**
     * 拦截抛出的自定义异常，并统一处理
     * @ControllerAdvice 标记这是控制层的通知
     */

    @ControllerAdvice
    public class MyControllerAdvice {

        /**
         * 自己定义的异常
         * @param myException
         * @return
         */
        @ExceptionHandler(MyException.class)
        public ModelAndView myExceptionHandler(MyException myException){
            //视图对象
            ModelAndView modelAndView = new ModelAndView();
            //存储错误信息
            modelAndView.addObject("code",myException.getCode());
            modelAndView.addObject("msg",myException.getMessage());
            modelAndView.addObject("getLocalize", myException.getLocalizedMessage());
            modelAndView.addObject("suppressed", myException.getSuppressed());
            //跳到显示错误的页面
            modelAndView.setViewName("result/exception_error");
            return modelAndView;
        }



    }
