package net.riyad.pres;

import net.riyad.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//version XML

public class PresSpringXML {
    static void main(String[] args) {
        ApplicationContext springContext =
                new ClassPathXmlApplicationContext("config.xml");

        //getBean("metier") <- avec id
        //IMetier metier = (IMetier) springContext.getBean("metier");

        //getBean(IMetier) <- avec interface + [pas besoin de faire le cast -> = (IMetier) ]
        IMetier metier = springContext.getBean(IMetier.class);

        System.out.println("RES="+metier.calcul());
    }

}
