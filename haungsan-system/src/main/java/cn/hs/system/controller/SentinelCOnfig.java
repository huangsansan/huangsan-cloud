package cn.hs.system.controller;

import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRule;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @Author: huangsan
 * @Date: 2020/5/25 11:06 下午
 */
@Component
public class SentinelCOnfig implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("i am run -----------");
        List<AuthorityRule> rules = new ArrayList<>();
        AuthorityRule rule = new AuthorityRule();
        rule.setResource("/system/sysuser/test");
        //配置白名单
        rule.setStrategy(RuleConstant.AUTHORITY_BLACK);
        rule.setLimitApp("appA");
        rules.add(rule);
        AuthorityRuleManager.loadRules(rules);
    }
}
