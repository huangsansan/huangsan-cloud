package cn.hs.system.service.impl;

import cn.hs.system.dao.SysFunctionDao;
import cn.hs.system.entity.SysFunctionEntity;
import cn.hs.system.service.SysFunctionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service("sysFunctionService")
public class SysFunctionServiceImpl extends ServiceImpl<SysFunctionDao, SysFunctionEntity> implements SysFunctionService {


}
