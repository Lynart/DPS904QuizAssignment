package quiz.classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class InitDatabase {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		
		config.addAnnotatedClass(quiz.classes.User.class);
		config.configure();
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session current = factory.getCurrentSession();
		
		current.beginTransaction();
		User user = new User();
		user.setLogin("vince@gmail.com");
		user.setPassword("password");
		current.save(user);
		current.getTransaction().commit();

	}

}
