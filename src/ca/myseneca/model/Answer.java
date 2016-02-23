package ca.myseneca.model;

import javax.persistence.*;


@Entity
@Table(name="Answer")
public class Answer {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	//0 for incorrect, 1 for correct. Might use other integers 
	private Boolean correct;
	@ManyToOne
	private Question question;
	private String description;
	
	//getters
	public int getId(){
		return id;
	}
	public Boolean getCorrect(){
		return correct;
	}
	public Question getQuestion(){
		return question;
	}
	public String getDescription(){
		return description;
	}
	
	//setters
	public void setCorrect(Boolean c){
		correct = c;
	}
	public void setQuestion(Question q){
		question = q;
	}
	public void setDescription(String d){
		description = d;
	}
	
	//Useful methods
	public String toString(){
		return this.description;
	}
}
