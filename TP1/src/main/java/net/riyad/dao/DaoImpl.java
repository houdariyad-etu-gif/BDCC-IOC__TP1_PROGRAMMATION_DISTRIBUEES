package net.riyad.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//si on ne specifie pas d'objet [dans notre cas: objet="d"]<- il nous creera un objet avec meme nom de la classe aka ="DaoImpl"
//@Component("d") <--- @Component : is general .for the dao class we do @Repository
@Repository("d")
public class DaoImpl implements IDao {
    @Override
    public double getData() {
        System.out.println("Version base de données");
        double t = 34;
        return t;
    }
}
