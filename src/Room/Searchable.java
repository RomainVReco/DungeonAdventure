package Room;
import Item.*;


/**
 * L'interface searchable définit un objet pouvant etre fouille dans le jeu.
 * Cette interface est destinee a etre implementee par des classes qui representent
 * des objets ou des entités, en l'occurence des items.
 *
 * @author Walid, Romain, Godwill
 */
public interface Searchable {


    /**
     *
     * @return l'item trouvé lors de la recherche peut retourner "null" si aucun item n'est trouvé
     * ou si l'objet a deja ete fouille.
     */
    Item search();


}