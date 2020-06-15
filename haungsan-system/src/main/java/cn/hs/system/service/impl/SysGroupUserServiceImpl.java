package cn.hs.system.service.impl;

import cn.hs.system.dao.SysGroupUserDao;
import cn.hs.system.entity.SysGroupUserEntity;
import cn.hs.system.service.SysGroupUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service("sysGroupUserService")
public class SysGroupUserServiceImpl extends ServiceImpl<SysGroupUserDao, SysGroupUserEntity> implements SysGroupUserService {

}
