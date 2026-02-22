//package net.riyad.pres;
//
//import net.riyad.dao.IDao;
//import net.riyad.metier.IMetier;
//
//import java.io.File;
//import java.util.Scanner;
//
//public class Pres2 {
//    //FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException
//    static void main(String[] args) throws Exception{
//        Scanner scanner = new Scanner(new File("config.txt"));
//
//        String daoClassName = scanner.nextLine();
//        Class cDao = Class.forName(daoClassName);
//        IDao dao =(IDao) cDao.newInstance();
//
//        String metierClassName = scanner.nextLine();
//        Class cMetier = Class.forName(metierClassName);
//
//        IMetier metier =(IMetier) cMetier.getConstructor(IDao.class).newInstance(d);
//
//    }
//}
