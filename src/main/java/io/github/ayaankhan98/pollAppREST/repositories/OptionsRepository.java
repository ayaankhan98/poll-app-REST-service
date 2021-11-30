package io.github.ayaankhan98.pollAppREST.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.ayaankhan98.pollAppREST.models.Options;
import io.github.ayaankhan98.pollAppREST.models.Poll;

@Repository
public interface OptionsRepository extends JpaRepository<Options, Long> {
	
	public List<Options> findByPollId(Long id);
}
