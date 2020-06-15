package cn.hs.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.expression.OAuth2SecurityExpressionMethods;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @Author: huangsan
 * @Date: 2020/5/25 2:10 下午
 */
@Component
public class GatewayWebSecurityExpressionHandler extends OAuth2WebSecurityExpressionHandler {

    @Autowired
    private MyPermissionService myPermissionService;

    @Override
    protected StandardEvaluationContext createEvaluationContextInternal(Authentication authentication,
                                                                        FilterInvocation invocation) {
        StandardEvaluationContext ec = super.createEvaluationContextInternal(authentication, invocation);
        ec.setVariable("myPermissionService", myPermissionService);
        ec.setVariable("oauth2", new OAuth2SecurityExpressionMethods(authentication));
        return ec;
    }
}
