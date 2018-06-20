/*
package com.kaishengit.springMVCConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/templates/**")
                .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/templates/");
        registry.addResourceHandler("/bootstrap/**")
                .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/bootstrap/");
        registry.addResourceHandler("/css/**")
                .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/css/");
        registry.addResourceHandler("/dist/**")
                .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/dist/");
        registry.addResourceHandler("/js/**")
                .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/js/");
        registry.addResourceHandler("/plugins/**")
                .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/plugins/");
        super.addResourceHandlers(registry);
    }
}
*/
