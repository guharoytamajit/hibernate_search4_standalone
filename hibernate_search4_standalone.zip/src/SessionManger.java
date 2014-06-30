
       
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SessionManger {

	
	private static final EntityManagerFactory emf =  
	          Persistence.createEntityManagerFactory("customerManager");



	public static EntityManagerFactory getEntityManagerFactory() {
		return SessionManger.emf;
	}

	public static EntityManager getEntityManager() {
		return SessionManger.emf.createEntityManager();
	}



}
