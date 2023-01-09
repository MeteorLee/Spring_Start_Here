package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

//        Parrot p1 = context.getBean("parrot2",Parrot.class);
        Parrot p1 = context.getBean("miki",Parrot.class);
        System.out.println(p1.getName());

    }
}
