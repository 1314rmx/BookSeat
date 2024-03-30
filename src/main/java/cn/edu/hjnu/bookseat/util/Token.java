package cn.edu.hjnu.bookseat.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Token {
    private static String secret;
    @Value("${token.secret}")
    private void setSecret(String secret) {
        Token.secret = secret;
    }

    public static String generateToken(String username) {
        String token = JWT.create()
                .withClaim("username",username)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .sign(Algorithm.HMAC256(secret));
        return token;
    }
    public static String parseToken(String token) {
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(secret))
                .build()
                .verify(token);
        Claim user = decodedJWT.getClaims().get("username");
        return user.asString();
    }
}