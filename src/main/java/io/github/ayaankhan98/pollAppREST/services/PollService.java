package io.github.ayaankhan98.pollAppREST.services;

import io.github.ayaankhan98.pollAppREST.models.Poll;

public interface PollService {
	public Poll savePoll(Poll poll);
	
	public Poll getPoll(Long id);

	public Poll updatePoll(Poll poll);
	
	public void removePoll(Long id);
}
