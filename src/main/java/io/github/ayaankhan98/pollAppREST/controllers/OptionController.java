package io.github.ayaankhan98.pollAppREST.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.github.ayaankhan98.pollAppREST.models.Options;
import io.github.ayaankhan98.pollAppREST.services.OptionService;

@Controller
public class OptionController {
	
	@Autowired
	private OptionService oService;
	
	@PutMapping("/options")
	public ResponseEntity<Options> voteOption(@RequestBody Options option) {
		
		Options response = oService.getOption(option.getId());
		option.setPoll(response.getPoll());
		option.setName(response.getName());
		response = oService.voteOption(option);
		
		return new ResponseEntity<Options> (response, HttpStatus.OK);
	}
}
