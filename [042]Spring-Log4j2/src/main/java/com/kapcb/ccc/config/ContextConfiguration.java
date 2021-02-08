package com.kapcb.ccc.commons.config;

import com.kapcb.ccc.commons.utils.PropertiesUtil;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;

/**
 * <a>Title: ContextConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/7-16:39
 */
@Configuration
@Import(value = {ThymeleafConfiguration.class})
public class ContextConfiguration {

    @Bean
    public PropertiesFactoryBean propertiesFactoryBean(){
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        Resource[] systemPropertiesFileResources = PropertiesUtil.getSystemPropertiesFileResources();
        propertiesFactoryBean.setLocations(systemPropertiesFileResources);
        return propertiesFactoryBean;
    }
}