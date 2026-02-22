package net.riyad.pres;

import net.riyad.dao.IDao;
import net.riyad.metier.IMetier;

import java.io.File;
import java.util.Scanner;

public class Pres2 {
    //FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException
    static void main(String[] args) throws Exception{
        //lire le fichier
        Scanner scanner = new Scanner(new File("config.txt"));

        //lire le nom de la classe [la 1ere ligne]
        String daoClassName = scanner.nextLine();

        //version 1
        //creer un objet de cette classe [ici on ne connait pas le nom de la classe]
        //forName(on lui donne le nom de la classe)<-si la classe existe il va la charger en memoire sinon il va generer une exception 'ClassNotFoundException'
        Class cDao = Class.forName(daoClassName);

        //pour creer un objet de cette classe une fois telecharger en memoire
        //1er cas : en utilisant le constructeur sans parametres
        IDao d =(IDao) cDao.newInstance();
        //System.out.println(dao.getData());

        //version 2
        String metierClassName = scanner.nextLine();
        Class cMetier = Class.forName(metierClassName);
        IMetier metier =(IMetier) cMetier.getConstructor(IDao.class).newInstance(d);
        System.out.println("RES = "+metier.calcul());
    }
}
