package com.callor.jc.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

// web.xml 파일을 대신할 Java Config

public class AppWebXmlConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    // <context-param>에 설정한 root-context.xml을 초기화할 method
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    // <servlet>에 설정한 servlet-context.xml을 초기화할 method
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                ServletConfig.class,
                MyBatisConfig.class
        };
    }

    //    // resources mapping에 설정한 static 폴더들에 대한 초기화할 method
    // servlet-mapping에 설정한 url-pattern을 초기화할 method
    @Override
    protected String[] getServletMappings() {
        String[] mapping = new String[]{"/"};
        return mapping;
    }

    /**
     * POST로 전송되는 한글 데이터를 정상적으로 수신하기 위한 설정
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();

        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);

        return new Filter[]{encodingFilter};
    }
}
