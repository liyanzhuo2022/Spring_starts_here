package com.springstartshere.example1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // printBeans(context);
        // addBeansByProgram(context);
        // printUnlinkedBeans(context);
        // printLinkedBeansByMethod(context);
        // printLinkedBeansByParameter(context);
        printAutowired(context);

    }

    private static void printBeans(AnnotationConfigApplicationContext context) {
        Parrot p = context.getBean("parrot2", Parrot.class);
        System.out.println(p.getName());
        System.out.println(context.getBean(String.class));
        System.out.println(context.getBean(Integer.class));
        System.out.println(context.getBean(Puppy.class).getName());
    }

    /**
     * 也可以通过context对象直接加入Bean (programatically)
     * */
    private static void addBeansByProgram(AnnotationConfigApplicationContext context) {
        Parrot x = new Parrot();
        x.setName("Gaga");
        Supplier<Parrot> parrotSupplier = () -> x;
        context.registerBean("parrot4", Parrot.class, parrotSupplier);
        Parrot p2 = context.getBean("parrot4", Parrot.class);
        System.out.println(p2.getName());
    }

    private static void printUnlinkedBeans(AnnotationConfigApplicationContext context) {
        Person person = context.getBean("person", Person.class);
        Parrot parrot = context.getBean("parrot", Parrot.class);
        System.out.println(person.getName());
        System.out.println(parrot.getName());
        System.out.println(person.getParrot()); // would get null, the person doesn't own the parrot
    }

    private static void printLinkedBeansByMethod(AnnotationConfigApplicationContext context) {
        Person person = context.getBean("person2", Person.class);
        Parrot parrot = context.getBean("parrot", Parrot.class);
        System.out.println(person.getName());
        System.out.println(parrot.getName());
        System.out.println(person.getParrot()); // would get the parrot's name
    }

    private static void printLinkedBeansByParameter(AnnotationConfigApplicationContext context) {
        Person person = context.getBean("person", Person.class);
        Parrot parrot = context.getBean("parrot", Parrot.class);
        System.out.println(person.getName());
        System.out.println(parrot.getName());
        System.out.println(person.getParrot()); // would get the parrot's name
    }

    private static void printAutowired(AnnotationConfigApplicationContext context) {
        House house = context.getBean(House.class);
        System.out.println(house.getName());
        System.out.println(house.getPuppy());
    }
}
