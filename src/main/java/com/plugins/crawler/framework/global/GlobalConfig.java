package com.plugins.crawler.framework.global;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;

/**
 * Created by david.yun on 2017/5/24.
 */
@Order(1)
@Configuration
@Import(PathMatchingResourcePatternResolver.class)
@EnableWebMvc
public class GlobalConfig extends WebMvcConfigurerAdapter {

    @Autowired
    PathMatchingResourcePatternResolver resolver;

    @Bean
    public PropertiesFactoryBean prop() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        Resource[] resources = new Resource[1];
        resources[0] = resolver.getResource("classpath:configuration/WhoisServers.properties");
        propertiesFactoryBean.setLocations(resources);
        return propertiesFactoryBean;
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("message/messages");
        return resourceBundleMessageSource;
    }
}
