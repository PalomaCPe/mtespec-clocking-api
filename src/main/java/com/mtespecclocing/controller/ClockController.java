package com.mtespecclocing.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtespecclocing.model.Clock;
import com.mtespecclocing.service.ClockService;

@RestController
@RequestMapping("/api")
public class ClockController {

	@Autowired
    ClockService clockService;

    @GetMapping("/clock")
    public List<Clock> getAllClocks() {
        return clockService.getAllClocks();
    }

    @PostMapping("/clock/{id}")
    public Clock createClock(@Valid @RequestBody Clock clock, @PathVariable(value = "id") Long id) {
        return clockService.createClock(clock, id);
    }

    @GetMapping("/clock/{id}")
    public Clock getClockById(@PathVariable(value = "id") Long clockId) {
        return clockService.getClockById(clockId);
    }
}

