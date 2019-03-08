package uk.co.datadisk.filters.configuration.filters;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(Ordered.LOWEST_PRECEDENCE -3)
@Component
public class ONEFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("Inside ONEFilter (doFilterInternal): "+ servletRequest.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    // you can specify URL to ignore at the filter level
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        System.out.println("Inside ONEFilter (shouldNotFilter): this gets run regardless but determines if doFilterInternal runs");
        return new AntPathMatcher().match("/app/app", request.getServletPath());
    }

}
