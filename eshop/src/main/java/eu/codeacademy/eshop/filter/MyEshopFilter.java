package eu.codeacademy.eshop.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class MyEshopFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.trace("------> my eshop filter implementation :::before::: do filter chain");

        chain.doFilter(request, response);

        log.trace("------> my eshop filter implementation :::after::: do filter chain");
    }
}
