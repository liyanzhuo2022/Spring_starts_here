package com.springstartshere.example1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
/**
 * 通过@ComponentScan，Spring知道去哪里寻找有@Component注释的类
 * 默认扫描配置类在的包
 * */
@ComponentScan
public class ProjectConfig {

    /*通过Config类与@Bean来把Bean加入Spring Context：
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

//    @Bean
//    Person person() {
//        Person p = new Person();
//        p.setName("Ella");
//        return p;
//    }

    /**
     * Direct Wiring: （Wiring的形象理解：在Bean之间接线）
     * 创建“person has parrot”关系（有依赖关系的Beans）:
     * 直接调用parrot()方法
     * Note：
     * parrot() 在源码层面“看起来被调用了两次”，
     * 但在 Spring 运行时，返回的是同一个 Parrot 对象。
     * Spring改写了方法调用的含义。
     * */
//    @Bean
//    Person person2() {
//        Person p = new Person();
//        p.setName("Elsa");
//        // 如果parrot bean已存在于Spring context，Spring会直接从context里拿Bean
//        p.setParrot(parrot());
//        return p;
//    }

    /**
     * 通过函数的参数注入Bean的依赖
     * */
    @Bean
    public Person person(Parrot parrot) {
        Person p = new Person();
        p.setName("Dawang");
        p.setParrot(parrot);
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

//    @Bean
//    Parrot parrot2() {
//        var p = new Parrot();
//        p.setName("Miki");
//        return p;
//    }

//    @Bean
//    Parrot parrot3() {
//        var p = new Parrot();
//        p.setName("Riki");
//        return p;
//    }

}
