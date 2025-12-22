package com.springstartshere.example1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean("parrot2", Parrot.class);
        System.out.println(p.getName());
        System.out.println(context.getBean(String.class));
        System.out.println(context.getBean(Integer.class));
        System.out.println(context.getBean(Puppy.class).getName());

        // 也可以通过context对象直接加入Bean (programatically)
        Parrot x = new Parrot();
        x.setName("Gaga");
        Supplier<Parrot> parrotSupplier = () -> x;
        context.registerBean("parrot4", Parrot.class, parrotSupplier);
        Parrot p2 = context.getBean("parrot4", Parrot.class);
        System.out.println(p2.getName());
    }
}
