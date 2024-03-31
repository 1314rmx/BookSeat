package cn.edu.hjnu.bookseat.service.Impl;

import cn.edu.hjnu.bookseat.pojo.reservations;
import cn.edu.hjnu.bookseat.pojo.users;
import cn.edu.hjnu.bookseat.service.userService;
import cn.edu.hjnu.bookseat.utils.Result;
import cn.edu.hjnu.bookseat.utils.ThreadLocalUtil;
import cn.edu.hjnu.bookseat.utils.Token;
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
                ThreadLocalUtil.set(user.getUsername());
            }catch (Exception e){
                return Result.error("token生成失败");
            }
            return Result.success(token);
        } else {
            return Result.error("密码错误");
        }
    }

    @Override
    public Result<users> getUserInfo() {
        String username = ThreadLocalUtil.get();
        return Result.success(userMapper.getUserInfo(username));
    }

    @Override
    public Result<String> updatePWD(String oldPWD, String newPWD) {
        String username = ThreadLocalUtil.get();
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

    @Override
    public Result<String> scan(int seatID) {
        reservations reservations = userMapper.getSeatStatus(seatID);
        if (reservations==null){
            return Result.error(404,"该座位未预约");
        }
        if(reservations.getUsername().equals(ThreadLocalUtil.get())){
            if (reservations.getStatus().equals("left")){
                if(userMapper.sign(reservations.getReservationId())){
                    return Result.success("签到成功");
                }
                else {
                    return Result.error("签到失败");
                }
            }else if (reservations.getStatus().equals("reserved")){
                if(userMapper.sign(reservations.getReservationId())){
                    return Result.success("签到成功");
                }else {
                    return Result.error("签到失败");
                }
            }else {
                return Result.error("该座位已被预约!");
            }
        }
        return Result.error(405,"该座位已被别人预约!");
    }
}