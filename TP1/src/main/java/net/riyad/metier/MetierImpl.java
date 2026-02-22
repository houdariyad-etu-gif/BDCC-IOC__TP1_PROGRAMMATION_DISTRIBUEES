package net.riyad.metier;

import net.riyad.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//version Annotation (des composants)

//si on ne specifie pas d'objet [dans notre cas: objet="metier"]<- il nous creera un objet avec meme nom de la classe [specifiant package et la classe<== identifiant]et aka ="MetierImpl"
//@Component("metier") <--- @Component : is general .for the dao class we do @Service

@Service("metier")
public class MetierImpl implements IMetier {

    //injection automatique -> on utilise Autowired avant la propriete 'dao' et puis spring injecte automatiquement un objet de type 'IDao'
    //@Autowired
    //@Qualifier("d2")
    //couplage faible
    private IDao dao;

    /* BONNE PRATIQUE : INJECTION VIA CONSTRUCTEUR
     *Pour injecter dans l'attribut dao
     *un objet d'une classe qui implemente l interface IDO
     *au moment de l'instantiation (au moment de creation de l'objet)
     */

    //si on utilise injection par constructeur avec parametre

    public MetierImpl(@Qualifier("d2") IDao dao) {
        this.dao = dao;
    }
    // ---> il faut supprimer le constructeur sans parametres  : [public MetierImpl() {}]

    //pour creer un objet MetierImpl on utilise un constructeur sans parametres
    // public MetierImpl() {}

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
