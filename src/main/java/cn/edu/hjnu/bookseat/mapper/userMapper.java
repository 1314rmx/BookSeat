package cn.edu.hjnu.bookseat.mapper;

import cn.edu.hjnu.bookseat.pojo.reservations;
import cn.edu.hjnu.bookseat.pojo.users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface userMapper {
    //登录判断
    @Select("select password from users where username=#{username}")
    String login(String username);
    @Select("select * from users where username=#{username}")
    users getUserInfo(String username);
    @Update("update users set password=#{newPWD} where username=#{username}")
    boolean updatePWD(@Param("username") String username,@Param("newPWD") String newPWD);
    @Select("select * from seatstatus where seatId=#{seatID};")
    reservations getSeatStatus(int seatID);
    @Update("update reservations set status='signed' where reservationID=#{reservationId}")
    boolean sign(int reservationId);
}