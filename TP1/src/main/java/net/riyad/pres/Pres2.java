package net.riyad.pres;

import net.riyad.dao.IDao;
import net.riyad.metier.IMetier;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres2 {
    //FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException
    static void main(String[] args) throws Exception {

        //lire le fichier 'config.txt'
        Scanner scanner = new Scanner(new File("config.txt"));
        //creer objet
        String daoClassName = scanner.nextLine();
        Class cDao = Class.forName(daoClassName);
        IDao d =(IDao) cDao.newInstance();


        /* ETAPES POUR CREER UN OBJET DYNAMIQUEMENT :
         *
         * 1) Lire le nom de la classe (String)
         * 2) Charger ou creer la classe en mémoire (Class.forName)
         * 3) Instancier la classe [Créer une instance] (newInstance ou constructeur)
         *
         * En résumé :
         *
         *   String className = scanner.nextLine();
         *   Class c = Class.forName(className);
         *   IDao d =(IDao) cDao.newInstance();
         *
         * -> pour 3 eme phase: instanciation :[Preferable: injection via constructeur avec parametres]
         *     -----------------------------------
         *      . 1er cas : Injection via le constructeur sans parametres:
         *      => IDao d =(IDao) cDao.newInstance();
         *
         *      . 2eme cas: Injection via constructeur avec parametres:
         *      => IMetier metier =(IMetier) cMetier.getConstructor(IDao.class).newInstance(d);
         *
         *      . 3eme cas: injection via le setter:
         *      => setDao.invoke(metier,d);
         *    --------------------------------------
         * IMPORTANT :
         * Class.forName(...) :
         *   - Charge la classe en mémoire
         *   - Génère ClassNotFoundException si elle n’existe pas
         */

        //System.out.println(dao.getData()); <-//test:
        String metierClassName = scanner.nextLine();
        Class cMetier = Class.forName(metierClassName);
        //Preferable : Injection via constructeur avec parametres
        IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(d);
        //constructeur sans parametres
        //IMetier metier =(IMetier) cMetier.getConstructor().newInstance();
        //Method <- methode a utiliser pour invoker via setter
        //Method setDao = cMetier.getDeclaredMethod("setDao",IDao.class);

        //invoker = executer la methode :

        //1 -- invoker statiquement(on a fait cela en pres1)
        //metier.setDao(d);

        //2-- invoker dynamiquement [par reflection] (meme chose qu on a fait en pres1 mais de maniere dynamique)
        //2eme cas : as Preferable : injection en utilisant le setter
        //setDao.invoke(metier,d);

        System.out.println("RES = "+metier.calcul());
    }
}
