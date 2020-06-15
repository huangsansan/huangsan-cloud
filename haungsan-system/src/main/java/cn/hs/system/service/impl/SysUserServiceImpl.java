package cn.hs.system.service.impl;

import cn.hs.system.dao.SysUserDao;
import cn.hs.system.entity.SysUserEntity;
import cn.hs.system.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

}
