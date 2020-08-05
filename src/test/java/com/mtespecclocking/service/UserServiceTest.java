package com.mtespecclocking.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mtespecclocing.model.User;
import com.mtespecclocing.repository.UserRepository;
import com.mtespecclocing.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserService.class)
public class UserServiceTest {
	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository userRepo;
	
	@Test
	public void testCreateTicket(){
		
		User user = new User();
		user.setCpf("123444444");
		user.setName("Nome");
		user.setEmail("email");
		
	    Mockito.when(userRepo.save(user)).thenReturn(user);
	    assertThat(userService.createUser(user)).isEqualTo(user);
	}
}
