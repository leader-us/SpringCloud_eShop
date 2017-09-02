package com.mycat.monoeshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Desc:
 *
 * @date: 27/08/2017
 * @author: Leader us
 */
@EnableFeignClients
@SpringCloudApplication
public class App extends WebMvcConfigurerAdapter {
	public static final String SESSION_KEY = "SESSION";

	@Autowired
	SecurityInterceptor inteseptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(inteseptor).excludePathPatterns("/", "/login.html", "/account/login",
				"/session/**", "/detail.html", "/products/**").addPathPatterns("/**");
		super.addInterceptors(registry);
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
