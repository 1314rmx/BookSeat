package cn.edu.hjnu.bookseat.service.Impl;

import cn.edu.hjnu.bookseat.pojo.users;
import cn.edu.hjnu.bookseat.service.userService;
import cn.edu.hjnu.bookseat.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.hjnu.bookseat.mapper.userMapper;

@Service
public class userServiceImpl implements userService {
    @Autowired
    private userMapper userMapper;
    @Override
    public Result login(users user) {
        users users = userMapper.login(user.getUsername());
        if (users==null){
            return Result.error("账号或密码错误!");
        }
        if (users.getPassword().equals(user.getPassword()))
            return Result.success();
        else
            return Result.error("密码错误");
    }
}
