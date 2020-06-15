/**
 * 
 */
package cn.hs.gateway.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

/**
 * @Description: 鉴权服务
 * @Param:
 * @return:
 * @Author: huangsan
 * @Date: 2020/5/25
 */
public interface MyPermissionService {
	
	boolean hasPermission(HttpServletRequest request, Authentication authentication);

}
