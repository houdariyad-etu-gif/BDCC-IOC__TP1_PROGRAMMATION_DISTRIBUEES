package net.riyad.pres;

import net.riyad.dao.DaoImpl;
import net.riyad.metier.MetierImpl;

public class Pres1 {
    public static void main(String[] args){
        DaoImpl d = new DaoImpl();
        MetierImpl metier = new MetierImpl();
        //injection des dependances via le setter
        metier.setDao(d);
        System.out.println("RES = "+metier.calcul());

    }
}
