package cn.hs.system.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @Author: huangsan
 * @Date: 2020/5/26 12:58 上午
 */
@Component
public class MyRequestOriginParse implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        return "appA";
    }
}
