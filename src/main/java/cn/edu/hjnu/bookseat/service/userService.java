package cn.edu.hjnu.bookseat.service;

import cn.edu.hjnu.bookseat.pojo.users;
import cn.edu.hjnu.bookseat.utils.Result;
import jakarta.servlet.http.HttpServletRequest;

public interface userService {
    public Result<String> login(users users);

    public Result<users> getUserInfo();

    Result<String> updatePWD(String oldPWD, String newPWD);

    Result<String> scan(int seatID);
}