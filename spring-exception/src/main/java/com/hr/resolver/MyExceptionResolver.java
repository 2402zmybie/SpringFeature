package com.hr.resolver;

import com.hr.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//自定义的异常处理器
public class MyExceptionResolver implements HandlerExceptionResolver {

    /**
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e 报异常的异常对象
     * @return 跳转的错误视图信息
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv = new ModelAndView();
        if(e instanceof MyException) {
            mv.addObject("info", "自定义异常");
        }else if(e instanceof ClassCastException) {
            mv.addObject("info", "类型转换异常");
        }
        mv.setViewName("error");
        return mv;
    }
}
