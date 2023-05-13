package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Quizz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String question;
	@ElementCollection
	private List<String> options;
	
	private String rightAnswer;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	private boolean active;
	
	public Quizz() {}

	public Quizz(String question, List<String> options, String rightAnswer, LocalDateTime startDate, LocalDateTime endDate,Boolean active) {
		super();
		this.question = question;
		this.options = options;
		this.rightAnswer = rightAnswer;
		this.startDate = startDate;
		this.endDate = endDate;
		this.active = active;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Quizz [id=" + id + ", question=" + question + ", options=" + options + ", rightAnswer=" + rightAnswer
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", active=" + active + "]";
	}

	

}
