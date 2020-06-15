package cn.hs.system.controller;

import cn.hs.system.entity.SysUserEntity;
import cn.hs.system.service.SysUserService;
import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 系统_用户
 *
 * @author huangsan
 * @email 1173234554@qq.com
 * @date 2020-05-23 16:26:24
 */
@RestController
@RequestMapping("system/sysuser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping
    public String add() {
        SysUserEntity entity = new SysUserEntity();
        entity.setUserName("hahahahah");
        sysUserService.save(entity);
        System.out.println("添加成功");
        return "i am ok";
    }

    @PostMapping
    public SysUserEntity get() {
        QueryWrapper<SysUserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", 5);
        List<SysUserEntity> list = sysUserService.list(wrapper);
        return list.get(0);
    }

    @RequestMapping("test")
//    @SentinelResource("testresource")
    public String get(@AuthenticationPrincipal String username) {

//        System.out.println(Thread.currentThread());
        //ContextUtil.exit();

        Entry entry = null;
        try {
            entry = SphU.entry("/system/sysuser/test");
            System.out.println("访问通过！");
            return "ok";
        } catch (BlockException e) {
            System.out.println("访问受限！");
            return "error";
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
    }


}
