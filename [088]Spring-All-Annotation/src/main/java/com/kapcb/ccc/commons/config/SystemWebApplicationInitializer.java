package com.kapcb.ccc.commons.config;

import ch.qos.logback.classic.servlet.LogbackServletContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * <a>Title: ApplicationContextConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/21 13:26
 */
public class SystemWebApplicationInitializer implements WebApplicationInitializer {

    private static final Logger log = LoggerFactory.getLogger(SystemWebApplicationInitializer.class);

    /**
     * 1、WebApplicationInitializer 是Spring 提供用来配置 Servlet 3.1+配置的接口，
     * 从而实现了替代web.xml的位置。实现此接口将会自动被 SpringServletContainerInitializer(用来启动 Servlet3.1容器）获取到。
     * <p>
     * 2、新建 WebApplicationContext,注册配置类，并将其和当前servletContext 关联。
     * <p>
     * 3、注册 Spring MVC的 DispatcherServlet
     *
     *
     * <groupId>javax.servlet</groupId>
     * <artifactId>javax.servlet-api</artifactId>
     * <version>4.0.1</version>
     *
     * @param servletContext ServletContext
     * @throws ServletException ServletException
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        log.info("come into onStartup method...");
        /**
         * 加载父子容器
         * 注解配置的SpringContext
         */
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();

        /**
         * webApplicationContext.register()加载配置文件,需要加入容器的就一个一个注册即可
         */
        log.info("begin to register context application configuration...");
        /**
         * 相当于 spring.xml
         */
        webApplicationContext.register(ContextApplicationConfiguration.class);

        log.info("begin to register web application configuration...");

        /**
         * 相当于 spring-mvc.xml
         */
        webApplicationContext.register(WebApplicationConfiguration.class);

        webApplicationContext.setServletContext(servletContext);


        log.info("begin to add filter into spring application context...");
        /**
         * Filter 处理乱码
         */
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setEncoding("UTF-8");
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("characterEncodingFilter", characterEncodingFilter);
        encodingFilter.addMappingForUrlPatterns(null, true, "/*");

        log.info("begin to add listener into spring application context...");
        /**
         * Listener logback
         */
        LogbackServletContextListener logbackServletContextListener = new LogbackServletContextListener();
        servletContext.addListener(logbackServletContextListener);
        servletContext.setInitParameter("logbackConfigLocation", "classpath:logback-spring.xml");

        log.info("begin to add dispatcherServlet into spring application context...");
        /**
         * 创建dispatcherServlet
         */
        ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(webApplicationContext));

        log.info("begin to set mapping into dispatcherServlet...");
        /**
         * 添加上下文路径地址
         */
        dispatcherServlet.addMapping("/");

        log.info("begin to set load on start up to 1...");
        /**
         * 最优先启动
         */
        dispatcherServlet.setLoadOnStartup(1);
    }
}
