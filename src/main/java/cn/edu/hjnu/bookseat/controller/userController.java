package cn.edu.hjnu.bookseat.controller;

import cn.edu.hjnu.bookseat.pojo.users;
import cn.edu.hjnu.bookseat.service.userService;
import cn.edu.hjnu.bookseat.utils.Result;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
public class userController {
    @Autowired
    private userService userService;
    //登录
    @PostMapping("/login")
    @ResponseBody
    public Result<String> login(users users){
        return userService.login(users);
    }
    //获取个人信息
    @GetMapping("/getUserInfo")
    @ResponseBody
    public Result<users> getUserInfo(HttpServletRequest request){
        return userService.getUserInfo(request);
    }
    //更新密码
    @PostMapping("/updatePWD")
    @ResponseBody
    public Result<String> updatePWD(HttpServletRequest request,@RequestParam("oldPWD") String oldPWD,@RequestParam("newPWD") String newPWD){
        return userService.updatePWD(request,oldPWD,newPWD);
    }
}