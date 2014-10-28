package mybeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class EJBTest
 */
@Stateless
@LocalBean
public class EJBTest implements EJBTestRemote, EJBTestLocal {

    /**
     * Default constructor. 
     */
    public EJBTest() {
        // TODO Auto-generated constructor stub
    }

}
