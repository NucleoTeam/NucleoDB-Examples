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
    /*
    Feature: Read To Time, will read only changes equal to or before the date set.
     */
    //readToTime = "2023-12-17T00:42:32.906539Z",
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
