package com.hr.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hr.domain.ResultData;
import com.hr.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @GetMapping("/quick5555")
    @ResponseBody
    public ResultData save5555() throws JsonProcessingException {
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setUsername("hr");
        user.setAge(27);
        userList.add(user);

        ResultData resultData = new ResultData();
        resultData.setCode("200");
        resultData.setMsg("数据请求成功");
        resultData.setData(userList);
        return resultData;
    }

    @GetMapping("/quick10")
    @ResponseBody
    public User save10() throws JsonProcessingException {
        User user = new User();
        user.setUsername("hr");
        user.setAge(27);
        return user;
    }


    @GetMapping("/quick9")
    @ResponseBody
    public String save9() throws JsonProcessingException {
        User user = new User();
        user.setUsername("hr");
        user.setAge(27);
        //使用json转换工具将对象转换成json格式的字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }


    @GetMapping("/quick8")
    @ResponseBody
    public String save8(){
        return "{\"username\":\"hr\", \"age\": 18}";
    }

    @GetMapping("/quick7")
    @ResponseBody  //告知springmvc框架 该方法不进行页面或者视图跳转,直接进行数据响应
    public String save7(){
        return "hello springmvc";
    }

    @GetMapping("/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().write("hello world");
    }

    //这种方式不常用
    @GetMapping("/quick5")
    public String save5(HttpServletRequest request) {
        request.setAttribute("username","张");
        return "success";
    }

    @GetMapping("/quick4")
    public String save4(Model model) {
      model.addAttribute("username", "何");
      return "success";
    }

    //MVC框架调用这个, 发现这个方法有参数, 则传递参数进来, 可以直接使用
    @GetMapping("/quick3")
    public ModelAndView save3(ModelAndView mv) {
        //设置模型数据
        mv.addObject("username", "ling");
        //设置视图名称 ,最终返回 /jsp/success.jsp
        mv.setViewName("success");
        return mv;
    }

    @GetMapping("/quick2")
    public ModelAndView save2() {
        ModelAndView mv = new ModelAndView();
        //设置模型数据
        mv.addObject("username", "hr");
        //设置视图名称 ,最终返回 /jsp/success.jsp
        mv.setViewName("success");
        return mv;
    }


    @GetMapping("/quick")
    public String save() {
        System.out.println("Controller save running...");
        return "success";
    }

}
