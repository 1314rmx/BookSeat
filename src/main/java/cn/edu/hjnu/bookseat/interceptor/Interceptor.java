package cn.edu.hjnu.bookseat.interceptor;

import cn.edu.hjnu.bookseat.utils.ThreadLocalUtil;
import cn.edu.hjnu.bookseat.utils.Token;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        String username;
        try {
            username = Token.parseToken(token);
            ThreadLocalUtil.set(username);
        } catch (Exception e) {
            return false;
        }
        return username != null;
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalUtil.remove();
    }
}
