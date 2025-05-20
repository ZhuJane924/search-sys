package com.office.analysis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.office.analysis.mapper.AuthorMapper;
import com.office.analysis.entity.Author;

@SpringBootApplication
@MapperScan("com.office.analysis.mapper")
public class AnalysisApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AnalysisApplication.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }

    @Bean
    CommandLineRunner testDB(AuthorMapper testUserMapper) {
        return args -> {
            Author user = new Author();
            user.setId(1);
            testUserMapper.insert(user);
            System.out.println("成功插入测试用户！");
        };
    }

}
