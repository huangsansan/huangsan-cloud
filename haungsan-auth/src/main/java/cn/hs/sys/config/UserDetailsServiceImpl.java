package cn.hs.sys.config;

import cn.hs.sys.Constant;
import cn.hs.sys.dao.SysUserEntity;
import cn.hs.sys.dao.UserPermissionRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @Author: huangsan
 * @Date: 2020/5/8 4:53 下午
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserPermissionRepository userPermissionRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isBlank(username)) {
            throw new UsernameNotFoundException("账号错误");
        }
        SysUserEntity sysUserEntity = userPermissionRepository.findUserIdByName(username);
        if (sysUserEntity == null) {
            throw new UsernameNotFoundException("账号异常");
        }
        if (Constant.USER_OFF.equals(sysUserEntity.getUserStatus())) {
            throw new UsernameNotFoundException("账号状态异常");
        }
        if (sysUserEntity.getUserId() != null) {
            List<String> permissionStrs = userPermissionRepository.listPermissionById(sysUserEntity.getUserId());

            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            permissionStrs.forEach(permissionStr -> {
                if (StringUtils.isNotBlank(permissionStr)) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permissionStr);
                    grantedAuthorities.add(grantedAuthority);
                }
            });
            //密码加密方式为：passwordEncoder.encode()
            return new User(username, sysUserEntity.getUserPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("账号异常");
        }
    }
}
