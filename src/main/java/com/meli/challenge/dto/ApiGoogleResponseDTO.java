package com.meli.challenge.dto;

public class ApiGoogleResponseDTO{
	private String id;
	private Boolean containsWord;
	private String title;
	private String description;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Boolean getContainsWord() {
		return containsWord;
	}
	public void setContainsWord(Boolean containsWord) {
		this.containsWord = containsWord;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
