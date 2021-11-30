package io.github.ayaankhan98.pollAppREST.responses;

import java.util.List;

import io.github.ayaankhan98.pollAppREST.models.Options;

public class PollResponse {
	private Long id;
	private String title;
	private String description;	
	private List<Options> options;
	
	public PollResponse() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	
	public List<Options> getOptions() {
		return options;
	}
	
	public void setOptions(List<Options> options) {
		this.options = options;
	}
	
	@Override
	public String toString() {
		return "PollResponse [id=" + id + ", title=" + title + ", description=" + description + ", options=" + options
				+ "]";
	}

	
}
