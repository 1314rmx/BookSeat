package cn.edu.hjnu.bookseat;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
class BookSeatApplicationTests {
    @Test
    void contextLoads() {
        //生成token
        Map<String, String> claims = new HashMap<>();
        claims.put("username", "admin");
        String token = JWT.create()
                .withClaim("user", "123456")
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .sign(Algorithm.HMAC256("secret"));
        System.out.println(token);
        //解析token
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256("secret"))
                .build()
                .verify(token);
        Claim user = decodedJWT.getClaims().get("user");
        System.out.println(user.asString());
    }

    @Test
    void test() {
        System.out.println(UUID.randomUUID());
    }
}