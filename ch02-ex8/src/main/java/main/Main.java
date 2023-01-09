package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = new Parrot();
        p.setName("Koko");

        Supplier<Parrot> parrotSupplier = () -> p;

        context.registerBean("parrot1", Parrot.class, parrotSupplier);
        context.registerBean("parrot2", Parrot.class, parrotSupplier, bc -> bc.setPrimary(true));

        Parrot x = context.getBean(Parrot.class);

        System.out.println(x.getName());
        System.out.println(p.getName());

    }
}
