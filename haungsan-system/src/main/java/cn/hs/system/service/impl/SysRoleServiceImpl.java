package cn.hs.system.service.impl;

import cn.hs.system.dao.SysRoleDao;
import cn.hs.system.entity.SysRoleEntity;
import cn.hs.system.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {


}
