package io.github.ayaankhan98.pollAppREST.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.ayaankhan98.pollAppREST.models.Poll;
import io.github.ayaankhan98.pollAppREST.repositories.PollRepository;

@Service
public class PollServiceImplementation implements PollService {

	@Autowired
	private PollRepository pRepository;

	public Poll savePoll(Poll poll) {
		return pRepository.save(poll);
	}

	@Override
	public Poll getPoll(Long id) {
		Optional<Poll> poll = pRepository.findById(id);
		
		if (poll == null) {
			return new Poll();
		}
		return poll.get();
	}

	@Override
	public void removePoll(Long id) {
		pRepository.deleteById(id);
	}

	@Override
	public Poll updatePoll(Poll poll) {
		return pRepository.save(poll);
	}
}
