package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext();

//        Parrot p = new Parrot();
        Parrot p = context.getBean(Parrot.class);

        System.out.println(p.getName());
    }
}