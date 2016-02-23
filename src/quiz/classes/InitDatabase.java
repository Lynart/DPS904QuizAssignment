package quiz.classes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InitDatabase {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void getEntityManager() {
		// Create the EntityManager
		emf = Persistence
				.createEntityManagerFactory("QuizEntityManager");
		em = emf.createEntityManager();
	}
	
	public void deleteAll(final Class<?> type) {
		getEntityManager();
		em.getTransaction().begin();
		em.createQuery("DELETE FROM " + type.getSimpleName() + " o").executeUpdate();
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public boolean insert(){
		User user = new User();
		user.setLogin("vince2@gmail.com");
		user.setPassword("password");
		getEntityManager();
		em.getTransaction().begin();
		
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return true;
	}

	public static void main(String[] args) {
		InitDatabase use = new InitDatabase();
		use.deleteAll(User.class);
		use.insert();
	}

}
