package com.metacoding.order.core.filter;

import com.metacoding.order.core.util.JwtProvider;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                   HttpServletResponse response, 
                                   FilterChain filterChain) throws ServletException, IOException {
        String token = jwtProvider.resolveToken(request);
        
        if (token != null && jwtProvider.validateToken(token)) {
            // 토큰이 유효하면 요청 속성에 사용자 ID 저장
            Integer userId = jwtProvider.getUserId(request);
            if (userId != null) {
                request.setAttribute("userId", userId);
            }
        }
        
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        // 인증 불필요한 경로
        return path.startsWith("/h2-console") ||
               path.startsWith("/actuator");
    }
}
