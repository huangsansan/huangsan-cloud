package cn.hs.system.service.impl;

import cn.hs.system.dao.SysGroupDao;
import cn.hs.system.entity.SysGroupEntity;
import cn.hs.system.service.SysGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service("sysGroupService")
public class SysGroupServiceImpl extends ServiceImpl<SysGroupDao, SysGroupEntity> implements SysGroupService {

}
