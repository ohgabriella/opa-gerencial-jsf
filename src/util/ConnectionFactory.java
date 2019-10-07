package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {


	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("opa-mysql");
	}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
