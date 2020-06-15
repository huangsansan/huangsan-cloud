package cn.hs.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.access.ExceptionTranslationFilter;

/**
 * @description:
 * @Author: huangsan
 * @Date: 2020/5/23 10:56 上午
 */
@Configuration
@EnableResourceServer
//@EnableOAuth2Sso
public class GatewaySecurityConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private GatewayAccessDeniedHandler gatewayAccessDeniedHandler;

    @Autowired
    private GatewayWebSecurityExpressionHandler gatewayWebSecurityExpressionHandler;

    @Autowired
    private GatewayAuthenticationEntryPoint gatewayAuthenticationEntryPoint;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources
                .authenticationEntryPoint(gatewayAuthenticationEntryPoint)
                .accessDeniedHandler(gatewayAccessDeniedHandler)
                .expressionHandler(gatewayWebSecurityExpressionHandler);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(new GatewayAuditLogFilter(), ExceptionTranslationFilter.class)
                .authorizeRequests()
                .antMatchers("/token/**")
                .permitAll()
                .antMatchers("/portal/**")
                .access("#myPermissionService.hasPermission(request, authentication)") //前台单独走权限控制
                .anyRequest()
                .authenticated();
    }
}
