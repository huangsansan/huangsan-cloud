package cn.hs.modules.back.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @Author: huangsan
 * @Date: 2020/5/22 5:22 下午
 */
@RestController
public class TestController {

    @RequestMapping("hello")
//    @PreAuthorize("hasRole('has')")
    @SentinelResource(value = "testBack", blockHandler = "whatfuck")
    public String a(String a, @AuthenticationPrincipal String username) throws InterruptedException {
        System.out.println(a);
        Thread.sleep(50);

//        try (Entry back = SphU.entry("testBack")) {
        return a + "hello " + username + " this is back";
//        } catch (BlockException e) {
//            return "isblock ";
//        }
    }

    public String whatfuck(String a, @AuthenticationPrincipal String username, BlockException e) throws InterruptedException {
        e.printStackTrace();
        return "i am very busy " + a;
    }
}
