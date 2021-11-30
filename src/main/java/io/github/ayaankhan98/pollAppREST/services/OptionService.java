package io.github.ayaankhan98.pollAppREST.services;

import java.util.List;

import io.github.ayaankhan98.pollAppREST.models.Options;

public interface OptionService {

	public Options saveOption(Options option); 
	
	public List<Options> getOptionsOfPoll(Long id); 
	
	public Options voteOption(Options option);
	
	public Options getOption(Long id);
}
