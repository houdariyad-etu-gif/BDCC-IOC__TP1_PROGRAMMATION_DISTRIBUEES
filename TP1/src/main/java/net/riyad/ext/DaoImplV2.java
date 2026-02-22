package net.riyad.ext;

import net.riyad.dao.IDao;
import org.springframework.stereotype.Component;

//@Component("d2") <--- @Component : is general .for the dao class we do @Repository
@Repository("d2")
public class DaoImplV2 implements IDao {

    @Override
    public double getData() {
        System.out.println("Version capteurs ...");
        double t = 12;
        return t;
    }
}
