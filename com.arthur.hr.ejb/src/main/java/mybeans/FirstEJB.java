package mybeans;

import java.io.Serializable;

import javax.ejb.Local;
import javax.ejb.Stateless;

import mybeans.interfaces.FirstEJBLocal;

/**
 * Session Bean implementation class FirstEJB
 */
@Stateless
@Local(FirstEJBLocal.class)
public class FirstEJB implements Serializable {

	private static final long serialVersionUID = 6575886709950300934L;

	/**
     * Default constructor. 
     */
    public FirstEJB() {
        // TODO Auto-generated constructor stub
    }

	public String getHelloWorld() {
		return "Hello World";
	}

}
