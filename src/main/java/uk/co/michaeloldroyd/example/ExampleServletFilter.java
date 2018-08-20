package uk.co.michaeloldroyd.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("exampleServletFilter")
public class ExampleServletFilter extends OncePerRequestFilter {
    private static final Logger LOG = LogManager.getLogger(ExampleServletFilter.class);
    public void doFilterInternal(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOG.info("Before filter chain {}", this.getClass());
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            LOG.info("After filter chain {}", this.getClass());
        }
    }
}
