package com.eci.cosw.springbootsecureapi;

import com.eci.cosw.springbootsecureapi.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;

@SpringBootApplication
public class SpringBootSecureApiApplication {


    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/api/*");

        return registrationBean;
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecureApiApplication.class, args);

//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
//        MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");
    }
}
