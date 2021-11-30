package io.github.ayaankhan98.pollAppREST.requests;

import java.util.List;

public class PollRequest {
	private String title;
	private String description;

	private List<String> options;

	public PollRequest() {
		
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

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "PollRequest [title=" + title + ", description=" + description + ", options=" + options + "]";
	}

}
