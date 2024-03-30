package cn.edu.hjnu.bookseat.controller;

import cn.edu.hjnu.bookseat.pojo.users;
import cn.edu.hjnu.bookseat.service.userService;
import cn.edu.hjnu.bookseat.util.Result;
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
    public Result login(users users){
        return userService.login(users);
    }
}
