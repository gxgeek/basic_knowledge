package com.gxgeek;

import com.gxgeek.mapper.BlogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class Application {


    @Autowired
    private ServiceA serviceA;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private BlogMapper blogMapper;

    @Bean
    public ApplicationRunner runner() {
        return args -> log.info(blogMapper.selectBlog(101).toString());
    }
    @Bean
    public ApplicationRunner runnerA() {
        return args -> serviceA.dot();
    }
}
