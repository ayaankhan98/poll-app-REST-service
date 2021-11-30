package io.github.ayaankhan98.pollAppREST.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.github.ayaankhan98.pollAppREST.requests.PollRequest;

@Entity
@Table(name = "poll")
public class Poll {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotBlank(message = "Please provide poll title")
	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "poll", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Options> options;
	
	public Poll() {

	}

	public List<Options> getOptions() {
		return options;
	}

	public void setOptions(List<Options> options) {
		this.options = options;
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

	@Override
	public String toString() {
		return "Poll [id=" + id + ", title=" + title + ", description=" + description + ", options=" + options + "]";
	}

	public Poll(PollRequest pRequest) {
		this.title = pRequest.getTitle();
		this.description = pRequest.getDescription();
	}

}
