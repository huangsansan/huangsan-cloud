/**
 *
 */
package cn.hs.gateway.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.http.AccessTokenRequiredException;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 处理401异常
 * @Param:
 * @return:
 * @Author: huangsan
 * @Date: 2020/5/25
 */
@Component
public class GatewayAuthenticationEntryPoint extends OAuth2AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        if (authException instanceof AccessTokenRequiredException) {
            System.out.println("2. udpate log to 401");
        } else {
            System.out.println("2. add log 401");
//            response.sendRedirect("/token/login");//没有登陆跳转登陆页
        }

        request.setAttribute("successFlag", "yes");

        super.commence(request, response, authException);
    }

}
