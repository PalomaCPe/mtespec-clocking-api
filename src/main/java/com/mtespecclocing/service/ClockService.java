package com.mtespecclocing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mtespecclocing.exception.NotFoundException;
import com.mtespecclocing.model.Clock;
import com.mtespecclocing.repository.ClockRepository;

@Component
public class ClockService {
	@Autowired
    ClockRepository clockRepository;

    public List<Clock> getAllClocks() {
        return clockRepository.findAll();
    }

    public Clock createClock(Clock clock) {
        return clockRepository.save(clock);
    }

    public Clock getClockById(Long clockId) {
        return clockRepository.findById(clockId)
                .orElseThrow(() -> new NotFoundException("Clock", "id", clockId));
    }
}
