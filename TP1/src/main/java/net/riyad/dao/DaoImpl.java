package net.riyad.dao;

import org.springframework.stereotype.Component;

//si on ne specifie pas d'objet [dans notre cas: objet="d"]<- il nous creera un objet avec meme nom de la classe aka ="DaoImpl"
@Component("d")
public class DaoImpl implements IDao {
    @Override
    public double getData() {
        System.out.println("Version base de données");
        double t = 34;
        return t;
    }
}
