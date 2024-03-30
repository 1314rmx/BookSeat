package cn.edu.hjnu.bookseat.service.Impl;

import cn.edu.hjnu.bookseat.pojo.users;
import cn.edu.hjnu.bookseat.service.userService;
import cn.edu.hjnu.bookseat.utils.Result;
import cn.edu.hjnu.bookseat.utils.Token;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.hjnu.bookseat.mapper.userMapper;

@Service
public class userServiceImpl implements userService {
    @Autowired
    private userMapper userMapper;
    @Override
    public Result<String> login(users user) {
        String password = userMapper.login(user.getUsername());
        if (password==null){
            return Result.error("账号或密码错误!");
        }
        if (password.equals(user.getPassword())) {
            String token;
            try {
                token = Token.generateToken(user.getUsername());
            }catch (Exception e){
                return Result.error("token生成失败");
            }
            return Result.success(token);
        } else {
            return Result.error("密码错误");
        }
    }

    @Override
    public Result<users> getUserInfo(HttpServletRequest request) {
        String username = Token.parseToken(request.getHeader("Authorization"));
        return Result.success(userMapper.getUserInfo(username));
    }

    @Override
    public Result<String> updatePWD(HttpServletRequest request, String oldPWD, String newPWD) {
        String username = Token.parseToken(request.getHeader("Authorization"));
        if (userMapper.login(username).equals(oldPWD)){
            if (userMapper.updatePWD(username,newPWD)){
                return Result.success("修改成功");
            }else {
                return Result.error("修改失败");
            }
        }else {
            return Result.error("密码错误");
        }
    }
}