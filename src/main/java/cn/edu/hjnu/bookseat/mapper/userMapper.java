package cn.edu.hjnu.bookseat.mapper;

import cn.edu.hjnu.bookseat.pojo.users;
import cn.edu.hjnu.bookseat.util.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface userMapper {
    //登录判断
    @Select("select password from users where username=#{username}")
    String login(String username);
    @Select("select * from users where username=#{username}")
    users getUserInfo(String username);
}