package com.example.welshcoding.interceptor;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/util/pattern/PathPattern.html
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginCheckInterceptor())
			.order(1)
			.addPathPatterns("/**")	
			.excludePathPatterns( "/","/css/**"); // 제외할 경우 //"/signup/**","/login_out/**",
	}
	
	/*
	@Bean
    public FilterRegistrationBean filterBean() {
    
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new ReloadFilter());
	    registrationBean.addUrlPatterns("/*"); //전체 URL 포함

        return registrationBean;
    }
    */
}
