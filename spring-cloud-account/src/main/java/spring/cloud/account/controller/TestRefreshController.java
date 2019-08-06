package spring.cloud.account.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试配置刷新
 */
@RestController
@RefreshScope
public class TestRefreshController {
    @Value("${refresh.test}")
    public String test;

    @RequestMapping("/test")
    public String test(){
        return test;
    }
}
