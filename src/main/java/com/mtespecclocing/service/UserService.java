package com.mtespecclocing.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.mtespecclocing.exception.NotFoundException;
import com.mtespecclocing.model.Clock;
import com.mtespecclocing.model.User;
import com.mtespecclocing.repository.UserRepository;

@Component
public class UserService {
	@Autowired
	UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User getUserById(Long userId) {
		return userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User", "id", userId));
	}

	public User getUserTotalHours(Long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User", "id", userId));

		user.setTotalHours(sumTime(user.getClock()));

		return user;
	}

	public User updateUser(Long userId, User userDetails) {
		User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User", "id", userId));

		user.setName(userDetails.getName());
		user.setCpf(userDetails.getCpf());
		user.setEmail(userDetails.getEmail());

		User updatedUser = userRepository.save(user);
		return updatedUser;
	}

	public ResponseEntity<?> deleteUser(Long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User", "id", userId));

		userRepository.delete(user);

		return ResponseEntity.ok().build();
	}

	private BigDecimal sumTime(List<Clock> clocks) {
		BigDecimal totalHours = new BigDecimal(0);
		if (clocks.isEmpty()) {
			Date initialDate = null;
			clocks.sort((o1, o2) -> o1.getClockDate().compareTo(o2.getClockDate()));

			for (Clock count : clocks) {
				if (count.getType().equals("Entrada")) {
					initialDate = count.getClockDate();
				} else {
					long diffInMillies = Math.abs(count.getClockDate().getTime() - initialDate.getTime());
					long diff = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);
					totalHours.add(new BigDecimal(diff));
				}

			}
		}

		return totalHours;
	}
}
