package ca.myseneca.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;


@Entity
@Table(name="Question")
public class Question {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	//1 for easy, 2 for medium, 3 for hard
	private int difficulty;
	@ManyToOne
	private Quiz quiz;
	private String description;
	private String explaination;
	//Will hardcode type of questions and construct the UI accordingly
	private String type;
	@OneToMany
	private Collection<Answer> answers;
	
	//getters
	public int getId(){
		return id;
	}
	public int getDifficulty(){
		return difficulty;
	}
	public Quiz getQuiz(){
		return quiz;
	}
	public String getDescription(){
		return description;
	}
	public String getExplaination(){
		return explaination;
	}
	public String getType(){
		return type;
	}
	public Collection<Answer> getAnswers(){
		return answers;
	}
	
	//setters
	public void setDifficulty(int d){
		difficulty = d;
	}
	public void setQuiz(Quiz q){
		quiz = q;
	}
	public void setDescription(String d){
		description = d;
	}
	public void setExplaination(String e){
		explaination = e;
	}
	public void setType(String t){
		type = t;
	}
	public void addAnswer(Answer a){
		answers.add(a);
	}
	
	//Constructor
	public Question(){
		answers = new ArrayList<Answer>();
	}
	
	//Useful methods
	public String toString(){
		return this.description;
	}
	
	//May be useful when randomizing question selection
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    if (!Question.class.isAssignableFrom(obj.getClass())) {
	        return false;
	    }
	    final Question other = (Question) obj;
	    if (this.id==other.id) {
	        return false;
	    }
	    return true;
	}
	
	//If are implement multi multi choice, this needs to be changed. 
	//If multi multi choice is not required for the assignment, lets not implement it
	public Answer getCorrectAnswer() throws Exception{
		for(Answer a : answers){
			if (a.getCorrect()){
				return a;
			}
		}
		throw new Exception("No answer found");
	}
}
