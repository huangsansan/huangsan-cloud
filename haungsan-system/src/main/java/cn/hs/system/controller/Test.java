package cn.hs.system.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRule;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRuleManager;

import java.util.Collections;

/**
 * @description:
 * @Author: huangsan
 * @Date: 2020/5/25 10:59 下午
 */
public class Test {

    public static void main(String[] args) {
        initRules();
        testFor();
    }

    private static void testFor() {

        Entry entry = null;
        try {
            entry = SphU.entry("testABC");
            System.out.println("ok");
        } catch (BlockException ex) {
            System.err.println("error");
        }
    }

    private static void initRules() {
        AuthorityRule rule = new AuthorityRule();
        rule.setResource("testABC");
        rule.setStrategy(RuleConstant.AUTHORITY_BLACK);
        rule.setLimitApp("appA");
        AuthorityRuleManager.loadRules(Collections.singletonList(rule));
        ContextUtil.enter("testABCdd", "appA");
    }
}
