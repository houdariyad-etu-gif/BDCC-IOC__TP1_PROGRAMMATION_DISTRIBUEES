package net.riyad.metier;

import net.riyad.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//version Annotation (des composants)

//si on ne specifie pas d'objet [dans notre cas: objet="metier"]<- il nous creera un objet avec meme nom de la classe [specifiant package et la classe<== identifiant]et aka ="MetierImpl"
@Component("metier")

public class MetierImpl implements IMetier {

    //injection automatique -> on utilise Autowired avant la propriete 'dao' et puis spring injecte automatiquement un objet de type 'IDao'
    @Autowired
    //@Qualifier("d2")
    //couplage faible
    private IDao dao;

    /* BONNE PRATIQUE : INJECTION VIA CONSTRUCTEUR
     *Pour injecter dans l'attribut dao
     *un objet d'une classe qui implemente l interface IDO
     *au moment de l'instantiation (au moment de creation de l'objet)
     */
    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    //pour creer un objet MetierImpl on utilise un constructeur sans parametres
    public MetierImpl() {
    }

    @Override
    public double calcul() {
        double t = dao.getData();
        double res = t * 12 *Math.PI/2 *Math.cos(t);
        return res;
    }

    /* MAUVAISE PRATIQUE: INJECTION VIA SETTER
     *Pour injecter dans l'attribut dao
     *un objet d'une classe qui implemente l interface IDO
     * apres instanciation (apres creation de l'objet)
     */
    public void setDao(IDao dao){
        this.dao = dao ;
    }








}
