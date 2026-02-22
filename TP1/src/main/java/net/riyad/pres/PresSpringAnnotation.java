package net.riyad.pres;

import net.riyad.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresSpringAnnotation {
    static void main(String[] args) {
        //dit a spring : cree des objets en se basant sur les annotations [il chercher les classes qui utilisents les annotations @Component dans notre projets et les instancient[les objets]]
        //+ on doit lui specifie les packages:
        // ApplicationContext applicationContext =
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext("net.riyad.dao","net.riyad.metier");
        // Preferable de specifier juste le package de base [parent]
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("net.riyad");
        IMetier metier = applicationContext.getBean(IMetier.class);
        System.out.println("RES="+metier.calcul());
    }
}
