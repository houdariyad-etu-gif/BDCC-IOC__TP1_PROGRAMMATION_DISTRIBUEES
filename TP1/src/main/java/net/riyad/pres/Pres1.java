package net.riyad.pres;

import net.riyad.dao.DaoImpl;
import net.riyad.ext.DaoImplV2;
import net.riyad.metier.MetierImpl;

public class Pres1 {
    public static void main(String[] args){
        //en utilisant classe DaoImpl : Version base de données
        //DaoImpl d = new DaoImpl();
        //en utilisant classe DaoImplV2 : Version capteurs
        DaoImplV2 d = new DaoImplV2();
        MetierImpl metier = new MetierImpl(d);
        //injection des dependances via le setter
        //metier.setDao(d);


        System.out.println("RES = "+metier.calcul());

    }
}
