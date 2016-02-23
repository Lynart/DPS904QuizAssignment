package ca.myseneca.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;


@Entity
@Table(name="Quiz")
public class Quiz {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date dateCreated;
	private int userScore;
	@OneToOne
	private User user;
	@OneToMany
	private Collection<Question> questions;
	
	
	//getters
	public int getId(){
		return id;
	}
	public Date getDateCreated(){
		return dateCreated;
	}
	public User getUser(){
		return user;
	}
	public int getUserScore(){
		return userScore;
	}
	
	//setters
	public void setUser(User i){
		user = i;
	}
	public void setUserScore(int s){
		userScore = s;
	}
	public void addQuestion(Question q){
		questions.add(q);
	}
	
	public Quiz(){
		questions = new ArrayList<Question>();
		dateCreated = new Date(); //Default is today
		userScore = 0;
		
		//Need some kind of random generation here for questions to pop 'em into the list
	}
}
