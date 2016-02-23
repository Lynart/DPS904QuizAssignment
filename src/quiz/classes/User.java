package quiz.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="User")

public class User {
	@Id @GeneratedValue
	private long id;
	@NotNull
	private String login;
	@NotNull
	private String password;

	//Getter and setters
	//Id
	//No setter because I can see dumb things happening to relationships otherwise
	public long getId(){
		return id;
	}
	
	//Login
	public String getLogin(){
		return login;
	}
	public void setLogin(String login){
		this.login=login;
	}
	
	//Password
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}
}
