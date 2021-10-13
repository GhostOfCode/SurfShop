//package com.demoshop.demoshop.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class StaticResourceConfiguration implements WebMvcConfigurer {
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry
//                .addResourceHandler("/styles/**")
//                .addResourceLocations("/styles/")
//                .setCachePeriod(3600)
//                .resourceChain(true);
////                .addResolver(new GzipResourceResolver())
////                .addResolver(new PathResourceResolver());
//    }
//}
