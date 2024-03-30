package cn.edu.hjnu.bookseat.mapper;

import cn.edu.hjnu.bookseat.pojo.users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface userMapper {
    //登录判断
    @Select("select * from users where username=#{username}")
    users login(String username);
}