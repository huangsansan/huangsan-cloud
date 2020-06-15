//package cn.hs.modules.back.config;
//
//import com.alibaba.csp.sentinel.slots.block.RuleConstant;
//import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
//import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @description: 模拟sentinel限流规则
// * @Author: huangsan
// * @Date: 2020/5/25 2:54 下午
// */
//@Component
//public class SentinelConfig implements ApplicationListener<ContextRefreshedEvent> {
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//        FlowRule flowRule = new FlowRule();
//        flowRule.setResource("testBack");
//        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
//        flowRule.setCount(1);
//        List<FlowRule> list = new ArrayList<>();
//        list.add(flowRule);
//        FlowRuleManager.loadRules(list);
//    }
//}
