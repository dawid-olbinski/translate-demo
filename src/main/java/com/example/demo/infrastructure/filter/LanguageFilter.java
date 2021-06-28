package com.example.demo.infrastructure.filter;

import com.example.demo.infrastructure.RequestContext;
import lombok.AllArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(1)
@AllArgsConstructor
public class LanguageFilter implements Filter {

    RequestContext requestContext;

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        requestContext.setIsoCode(req.getHeader("lang"));
        chain.doFilter(request, response);
    }

}
