package com.mtespecclocing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtespecclocing.model.Clock;

@Repository
public interface ClockRepository extends JpaRepository<Clock, Long> {

}