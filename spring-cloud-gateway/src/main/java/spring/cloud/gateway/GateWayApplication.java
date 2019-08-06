package spring.cloud.gateway;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@MapperScan("spring.cloud.gateway.dataaccess.mapper")
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
public class GateWayApplication{

	public static void main(String[] args) {
		SpringApplication.run(GateWayApplication.class, args);
	}

	@Configuration
	public class HystrixServletDefinitions {

		@Bean(name = "hystrixRegistrationBean")
		public ServletRegistrationBean servletRegistrationBean() {
			ServletRegistrationBean registration = new ServletRegistrationBean(
					new HystrixMetricsStreamServlet(), "/metrics/hystrix.stream");
			registration.setName("hystrixServlet");
			registration.setLoadOnStartup(1);
			return registration;
		}
	}
	
}