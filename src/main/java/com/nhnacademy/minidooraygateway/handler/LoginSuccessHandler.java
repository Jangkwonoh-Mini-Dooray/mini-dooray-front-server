//package com.nhnacademy.minidooraygateway.handler;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
//import org.springframework.data.redis.core.RedisTemplate;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
//    private final RedisTemplate<String, String> redisTemplate;
//
//    public LoginSuccessHandler(RedisTemplate<String, String> redisTemplate) {
//        this.redisTemplate = redisTemplate;
//    }
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        super.onAuthenticationSuccess(request, response, authentication);
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        List<GrantedAuthority> authorities = new ArrayList<>(userDetails.getAuthorities());
//
//        HttpSession session = request.getSession(false);
//        session.setMaxInactiveInterval(300000);
//
//        redisTemplate.opsForHash().put(session.getId(), "username", userDetails.getUsername());
//        redisTemplate.opsForHash().put(session.getId(), "authority", authorities.get(0).getAuthority());
//        redisTemplate.boundHashOps(session.getId()).expire(300000, TimeUnit.SECONDS);
//
//        session.setAttribute("username", userDetails.getUsername());
//        session.setAttribute("authority", authorities.get(0).getAuthority());
//    }
//}
