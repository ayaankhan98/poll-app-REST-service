package io.github.ayaankhan98.pollAppREST.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.ayaankhan98.pollAppREST.models.Options;
import io.github.ayaankhan98.pollAppREST.repositories.OptionsRepository;

@Service
public class OptionServiceImplementation implements OptionService {
	
	@Autowired
	private OptionsRepository oRepository;

	@Override
	public Options saveOption(Options option) {
		return oRepository.save(option);
	}
	
	@Override
	public List<Options> getOptionsOfPoll(Long id) {
		return oRepository.findByPollId(id);
	}

	@Override
	public Options voteOption(Options option) {
		return oRepository.save(option);
	}


	@Override
	public Options getOption(Long id) {
		Optional<Options> response = oRepository.findById(id);
		if (response == null) {
			return new Options();
		}
		return response.get();
	}
}
