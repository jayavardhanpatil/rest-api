package com.jay.Restful.Rest.model;

public class Comment {

	private long id;
	private String comment;
	private String author;

	public Comment(){
		
		
	}
	
	public Comment(long id,String comment,String author){
		
		this.id = id;
		this.author = author;
		this.comment = comment;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return comment;
	}

	public void setMessage(String message) {
		this.comment = message;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
}
