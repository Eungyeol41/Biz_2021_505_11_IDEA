package com.callor.jc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// servlet-context.xml 파일을 대신할 Java Config 클래스

/**
 * @Configuration: 이 파일은 context.xml을 대신할 파일이다
 * @EnableWebMvc: 이제 SpringMVC 프로젝트의 servlet이 시작된다
 *      servlet-context.xml, dispatcher-servlet.xml 등을 대신하는 파일
 * @ComponentScan: servlet-context.xml에서 component-scan 했던 부분
 */
@Configuration
@EnableWebMvc
// @ComponentScan(basePackages = {"com.callor.jc"})
@ComponentScan(basePackages = {"com.callor.jc.controller", "com.callor.jc.service"})
public class ServletConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");

        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

    // return type: ViewResolver
    /**
     * method에 @Bean Annotation을 부착하면 이 method는 반드시 객체를 생성해서 return 해야 한다.
     *      InternalResourceViewResolver를 생성해서 값을 return했음.
     * Spring 컨테이너는 프로젝트가 시작되는 시점에 이 method를 자동으로(강제로) 실행하고 생성된 객체를 컨테이너에 보관하여
     *      다른 곳에서 필요할 경우 주입하도록 준비해둔다.
     */
    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

}