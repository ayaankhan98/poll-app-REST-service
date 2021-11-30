package io.github.ayaankhan98.pollAppREST.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.ayaankhan98.pollAppREST.models.Poll;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {

}
