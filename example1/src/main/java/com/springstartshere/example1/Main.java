package com.springstartshere.example1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());
        System.out.println(context.getBean(String.class));
        System.out.println(context.getBean(Integer.class));
    }
}
