package io.github.ayaankhan98.pollAppREST.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.ayaankhan98.pollAppREST.models.Options;
import io.github.ayaankhan98.pollAppREST.models.Poll;
import io.github.ayaankhan98.pollAppREST.requests.PollRequest;
import io.github.ayaankhan98.pollAppREST.responses.PollResponse;
import io.github.ayaankhan98.pollAppREST.services.OptionService;
import io.github.ayaankhan98.pollAppREST.services.PollService;

@RestController
public class PollController {
	
	@Autowired
	private PollService pService;
	
	@Autowired
	private OptionService oService;
	
	@GetMapping("/polls/{id}")
	public ResponseEntity<PollResponse> getPoll(@PathVariable("id") Long id) {
		Poll p = pService.getPoll(id);
		List<Options> options = oService.getOptionsOfPoll(p.getId());

		PollResponse pResponse = new PollResponse();
		pResponse.setId(p.getId());
		pResponse.setTitle(p.getTitle());
		pResponse.setDescription(p.getDescription());
		pResponse.setOptions(options);
		
		return new ResponseEntity<PollResponse>(pResponse, HttpStatus.OK);
	}
	
	@PostMapping("polls")
	public ResponseEntity<String> savePoll(@Valid @RequestBody PollRequest pollRequest) {
		Poll poll = new Poll();
		poll.setTitle(pollRequest.getTitle());
		poll.setDescription(pollRequest.getDescription());
		
		poll = pService.savePoll(poll);
		
		for(String option: pollRequest.getOptions()) {
			Options o = new Options();
			o.setName(option);
			
			o.setPoll(poll);
			
			oService.saveOption(o);
		}
		
		return new ResponseEntity<String>("Saved record", HttpStatus.CREATED);
	}
	
	@DeleteMapping("polls/{id}")
	public ResponseEntity<String> deletePoll(@PathVariable("id") Long id) {
		pService.removePoll(id);
		return new ResponseEntity<String>("Record Deleted",HttpStatus.NO_CONTENT);
	}
}
