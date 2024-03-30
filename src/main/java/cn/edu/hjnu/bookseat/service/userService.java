package cn.edu.hjnu.bookseat.service;

import cn.edu.hjnu.bookseat.pojo.users;
import cn.edu.hjnu.bookseat.utils.Result;
import jakarta.servlet.http.HttpServletRequest;

public interface userService {
    public Result<String> login(users users);

    public Result<users> getUserInfo(HttpServletRequest request);

    Result<String> updatePWD(HttpServletRequest request, String oldPWD, String newPWD);
}