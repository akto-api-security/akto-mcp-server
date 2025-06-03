package io.akto.mcp.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class BearerTokenAuthFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
        try {
            String authHeader = request.getHeader("Authorization");

//            if (authHeader != null && authHeader.startsWith("Bearer ") && !authHeader.substring(7).isBlank()) {
//                String accessToken = authHeader.substring(7);
//
//                request.setAttribute("AKTO_API_KEY", accessToken);
//                AuthTokenContext.setToken(accessToken);
//
//                Authentication authenticationToken = new UsernamePasswordAuthenticationToken(null, null,
//                    null);
//                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//                filterChain.doFilter(request, response);
//            } else {
//                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            }
            filterChain.doFilter(request, response);
        } finally {
            AuthTokenContext.clear();
        }
    }
}
