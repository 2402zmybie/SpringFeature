package com.hr.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hr.domain.ResultData;
import com.hr.domain.User;
import com.hr.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @PostMapping("/quick23")
    @ResponseBody
    public void save23(String username, MultipartFile[] files) throws IOException {
        System.out.println(username);
        //获得上传文件的名称
        for (MultipartFile file : files) {
            String originalFilename = file.getOriginalFilename();
            //转移文件 保存
            file.transferTo(new File("C:\\upload\\" + originalFilename));
            System.out.println(file);
        }
    }

    @PostMapping("/quick22")
    @ResponseBody
    public void save22(String username, MultipartFile file) throws IOException {
        System.out.println(username);
        //获得上传文件的名称
        String originalFilename = file.getOriginalFilename();
        //转移文件 保存
        file.transferTo(new File("C:\\upload\\" + originalFilename));
        System.out.println(file);
    }


    @GetMapping("/quick21")
    @ResponseBody
    public void save21(@CookieValue(value ="JSESSIONID") String jsessionid) {
        System.out.println(jsessionid);
    }

    @GetMapping("/quick20")
    @ResponseBody
    public void save20(@RequestHeader(value = "User-Agent", required = false) String user_Agent) {
        System.out.println(user_Agent);
    }

    @GetMapping("/quick18")
    @ResponseBody
    public void save18(Date date) {
        //Mon Dec 12 00:00:00 CST 1910
        System.out.println(date);
    }

    @GetMapping("/quick17/{name}")
    @ResponseBody
    public void save17(@PathVariable(value = "name") String name) {
        System.out.println(name);
    }


    @GetMapping("/quick16")
    @ResponseBody
    public void save16(@RequestParam(value = "name", required = false, defaultValue = "hr") String username) {
        System.out.println(username);
    }

    @PostMapping("/quick15")
    @ResponseBody
    public void save15(@RequestBody List<User> userList) {
        System.out.println(userList);
    }

    @PostMapping("/quick14")
    @ResponseBody
    public void save14(VO vo) {
        System.out.println(vo);
    }

    //http://localhost:8080/spring_mvc_war_exploded/user/quick13?strs=111&strs=2
    @GetMapping("/quick13")
    @ResponseBody
    public void save13(String[] strs){
        //[111, 2]
        System.out.println(Arrays.asList(strs));
    }


    @GetMapping("/quick12")
    @ResponseBody
    public void save12(User user){
        //User{username='zhangsan', age=11}
        System.out.println(user);
    }


    @GetMapping("/quick11")
    @ResponseBody
    public void save11(String username, int age){
        System.out.println(username);
        System.out.println(age);
    }


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
