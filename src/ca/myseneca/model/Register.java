package ca.myseneca.model;

import javax.persistence.*;

public class Register {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void getEntityManager() {
		// Create the EntityManager
		emf = Persistence
				.createEntityManagerFactory("Quiz");
		em = emf.createEntityManager();

	}
	
	public void resetTables(){
		getEntityManager();
		em.getTransaction().begin();
		em.createQuery("DELETE FROM " + UserResponse.class.getSimpleName() + " o").executeUpdate();
		em.createQuery("DELETE FROM " + Answer.class.getSimpleName() + " o").executeUpdate();
		em.createQuery("DELETE FROM " + Question.class.getSimpleName() + " o").executeUpdate();
		em.createQuery("DELETE FROM " + Quiz.class.getSimpleName() + " o").executeUpdate();
		em.createQuery("DELETE FROM " + User.class.getSimpleName() + " o").executeUpdate();
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public void TestTables(){
		User u = new User();
		u.setLogin("vince@gmail.com");
		u.setPassword("1234");
		
		Quiz q = new Quiz();
		q.setUser(u);
		u.addQuiz(q);
		
		Question question = new Question();
		question.setQuiz(q);
		q.addQuestion(question);
	
		Answer a = new Answer();
		a.setQuestion(question);
		question.addAnswer(a);
		
		try{
			getEntityManager();
			em.getTransaction().begin();
			em.persist(u);
			em.persist(q);
			em.persist(question);
			em.persist(a);
			em.getTransaction().commit();
			em.close();
			emf.close();
		}
		catch(Exception e){
			//do something
		}
	}
	
	public static void main ( String[] args){
		Register register = new Register();
		register.resetTables();
		register.TestTables();
	}
}
