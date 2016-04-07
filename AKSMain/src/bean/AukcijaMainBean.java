package bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class AukcijaMainBean
 */
@Stateful
@LocalBean
public class AukcijaMainBean implements AukcijaMainBeanRemote, AukcijaMainBeanLocal {
@PersistenceContext
EntityManager em;
    /**
     * Default constructor. 
     */
    public AukcijaMainBean() {
        // TODO Auto-generated constructor stub
    }
    

}
