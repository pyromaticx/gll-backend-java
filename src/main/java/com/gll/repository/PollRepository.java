package com.gll.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.gll.domain.Poll;

public interface PollRepository extends PagingAndSortingRepository<Poll, Long> {

}
