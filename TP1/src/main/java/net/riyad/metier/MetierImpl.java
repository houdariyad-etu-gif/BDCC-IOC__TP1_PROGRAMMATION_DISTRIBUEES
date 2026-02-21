package net.riyad.metier;

import net.riyad.dao.IDao;

public class MetierImpl implements IMetier {
    //couplage faible
    private IDao dao;

    @Override
    public double calcul() {
        double t = dao.getData();
        double res = ((t * 12 *Math.PI) / 2) *Math.cos(t);
        return res;
    }

    /*
     *Pour injecter dans l'attribut dao
     *un objet d'une classe qui implemente l interface IDO
     *au moment de l'instantiation
     */
    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    //pour creer un objet MetierImpl on utilise un constructeur sans parametres
    public MetierImpl() {
    }

    /* MAUVAISE PRATIQUE:
    *Pour injecter dans l'attribut dao
    *un objet d'une classe qui implemente l interface IDO
    * apres instanciation
    */
    public void setDao(IDao dao){
        this.dao = dao ;
    }
}
