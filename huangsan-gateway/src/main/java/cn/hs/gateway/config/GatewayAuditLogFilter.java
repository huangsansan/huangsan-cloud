package cn.hs.gateway.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @Author: huangsan
 * @Date: 2020/5/25 11:42 上午
 */
public class GatewayAuditLogFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        System.out.println("1. add log for " + username);

        filterChain.doFilter(request, response);

        if (StringUtils.isBlank((String) request.getAttribute("successFlag"))) {
            System.out.println("3. update log success");
        }
    }

}
