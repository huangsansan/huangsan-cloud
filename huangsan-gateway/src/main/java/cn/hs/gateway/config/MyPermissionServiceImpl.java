/**
 *
 */
package cn.hs.gateway.config;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.http.AccessTokenRequiredException;
import org.springframework.stereotype.Service;


@Service
public class MyPermissionServiceImpl implements MyPermissionService {


    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        System.out.println("2 authorize");
        System.out.println(request.getRequestURI());
        System.out.println(ReflectionToStringBuilder.toString(authentication));

        if (authentication instanceof AnonymousAuthenticationToken) {
            throw new AccessTokenRequiredException(null);
        }

        return RandomUtils.nextInt() % 2 == 0;
    }

}
