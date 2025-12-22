package com.springstartshere.example1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    /*通过Config类与@Bean来创建Bean：
    * Spring创建context时，会读取我输入的参数（配置类），
    * 然后调用配置类的方法，把方法的返回值加入context，
    * 把方法名称作为Bean的名称
    * */
    @Bean
    Parrot parrot() {
        var p = new Parrot();
        p.setName("Kolo");
        return p;
    }

    @Bean
    String hello() {
        return "Hello";
    }

    @Bean
    Integer ten() {
        return 10;
    }

}
