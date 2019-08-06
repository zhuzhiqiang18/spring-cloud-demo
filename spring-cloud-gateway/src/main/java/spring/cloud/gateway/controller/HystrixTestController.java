package spring.cloud.gateway.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试熔断
 */
@RestController
public class HystrixTestController {
    @RequestMapping("/hystrixTest")
    @HystrixCommand(fallbackMethod = "hiError")
    public Object test(){
        int a=1/0;
        return "123";
    }


    public Object hiError(){
        Map<String,String> data = new HashMap<String, String>();
        data.put("code","500");
        data.put("msg","服务器故障");
        return data;
    }

}
