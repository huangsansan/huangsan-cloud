package cn.hs.modules.back.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @Author: huangsan
 * @Date: 2020/5/25 5:29 下午
 */
@RestController
@RequestMapping("test")
public class Test2Controller {

    @Autowired
    private OAuth2RestTemplate restTemplate;

    @RequestMapping("test")
    @SentinelResource("xxx")
    public String get() {

//        final String forObject = restTemplate.getForObject("http://localhost:52109/system/sysuser/test", String.class);
//        System.out.println("system return " + forObject);

        return "aa";
    }
}
