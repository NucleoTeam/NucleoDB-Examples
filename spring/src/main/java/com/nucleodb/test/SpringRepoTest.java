package com.nucleodb.test;

import com.nucleodb.library.NucleoDB;
import com.nucleodb.spring.config.EnableNDBRepositories;
import com.nucleodb.spring.NDBConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableNDBRepositories(
    dbType = NucleoDB.DBType.NO_LOCAL,
    kafkaServers = "127.0.0.1:19092,127.0.0.1:29092,127.0.0.1:39092",
    scanPackages = {
        "com.nucleodb.test.domain"
    },
    basePackages = "com.nucleodb.test.repo"
)
public class SpringRepoTest{
    public static void main(String[] args){
        SpringApplication.run(SpringRepoTest.class);
    }
    @Bean
    public NDBConfiguration createNDBConfig(){
        return new NDBConfiguration("com.nucleocore.test.spring.repo");
    }
}
