package com.books.config.filter;

import com.books.util.token.JWTToken;
import com.books.util.token.TokenEntity;
import com.books.util.token.TokenUtil;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@Component
public class JWTFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("token");
        if(token == null) {
            return;
        }
        TokenEntity appUID1 = JWTToken.getAppUID(token);
        request.setAttribute(TokenUtil.AUTH_SESSION_USER, appUID1);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
