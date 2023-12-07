package mpb.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final EntityManagerFactory entityManagerFactory;

	static {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("SQLitePU");
		} catch (Throwable ex) {
			System.err.println("Error creating EntityManagerFactory: " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public static void closeEntityManagerFactory() {
		entityManagerFactory.close();
	}
}
