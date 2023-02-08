package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration		// 설정정보 객체라는 표시 
@EnableWebMvc

// 자동으로 컴포넌트들을 찾아가기!
@ComponentScan(basePackages = "com.stone" )		// 이 이름의 하위 디렉토리를 자동으로 찾아간다.

public class MvcConfig implements WebMvcConfigurer{
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// 이 하위 디렉토리 안에 있는 모든 jsp 파일을 찾아감 
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	// 서블릿이 요청을 받을 때, jsp가 아닌 원래 디렉토리 찾아가기
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
	}
	
}
