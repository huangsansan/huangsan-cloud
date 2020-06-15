package cn.hs.gateway.config;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @Author: huangsan
 * @Date: 2020/5/25 11:56 上午
 */
@Component
public class GatewayAccessDeniedHandler extends OAuth2AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) throws IOException, ServletException {

        //接口上的hasRole会直接进入全局异常，不会进入当前方法。

        System.out.println("2. update log is 403");

        request.setAttribute("successFlag", "yes");

        super.handle(request, response, authException);
    }
}
