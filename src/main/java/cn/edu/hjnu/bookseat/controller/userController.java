package cn.edu.hjnu.bookseat.controller;

import cn.edu.hjnu.bookseat.pojo.users;
import cn.edu.hjnu.bookseat.service.userService;
import cn.edu.hjnu.bookseat.util.Result;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
public class userController {
    @Autowired
    private userService userService;
    @PostMapping("/login")
    @ResponseBody
    public Result<String> login(users users){
        return userService.login(users);
    }
    @GetMapping("/getUserInfo")
    @ResponseBody
    public Result<users> getUserInfo(HttpServletRequest request){
        return userService.getUserInfo(request);
    }
}