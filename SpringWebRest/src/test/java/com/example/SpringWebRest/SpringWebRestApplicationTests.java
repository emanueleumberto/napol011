package com.example.SpringWebRest;

import com.example.SpringWebRest.controllers.UserController;
import com.example.SpringWebRest.models.User;
import com.example.SpringWebRest.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class SpringWebRestApplicationTests {

	@Autowired SpringWebRestApplication app;
	//@Autowired private UserService userService;

	// MockMvc simula chiamate HTTP ai metodi del controller
	@Autowired private MockMvc mockMvc;
	@MockitoBean UserService userService;
	// Permette di convertire Oggetti Java in JSON e viceversa
	@Autowired ObjectMapper objectMapper;

	/*@Test
	void contextLoads() {
		assertThat(app).isNotNull();
	}*/

	// Test su Service

	User userCreated;

/*
	@BeforeEach
	void createUser() {
		System.out.println("Sono createUser");
		userCreated = new User();
		userCreated.setFirstname("Mario");
		userCreated.setLastname("Rossi");
		userCreated.setCity("Roma");
		userCreated.setAge(25);
		userCreated.setEmail("mario.rossi@example.com");
		userCreated.setPassword("qwerty");
		System.out.println(userCreated);
		userService.saveUser(userCreated);
	}

	@Test
	void getUserById() {
		User userRead = userService.findUser(userCreated.getId());
		assertNotNull(userRead);
	}

	@Test
	void updateUser() {
		userCreated.setPassword("Pa$$w0rd!");
		userService.saveUser(userCreated);
		User userRead = userService.findUser(userCreated.getId());
		System.out.println(userRead);
		assertEquals("Pa$$w0rd!", userRead.getPassword());
	}

	@AfterEach
	void removeUser() {
		System.out.println("Sono removeUser");
		userService.removeUser(userCreated);
	}
*/

	// Test su controller
	@Test
	void testCreateUser() throws Exception {
		User user = new User();
		user.setFirstname("Mario");
		user.setLastname("Rossi");
		user.setCity("Roma");
		user.setAge(25);
		user.setEmail("mario.rossi@example.com");
		user.setPassword("qwerty");

		User userSave = new User(11L, "Mario", "Rossi", "Roma", 25, "mario.rossi@example.com", "qwerty");

		when(userService.saveUser(Mockito.any(User.class))).thenReturn(userSave);

		mockMvc.perform(post("/api/users")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(user)))
						.andExpect(status().isCreated())
						.andExpect(jsonPath("$.id").value(11L))
						.andExpect(jsonPath("$.email").value("mario.rossi@example.com"));

		verify(userService, times(1)).saveUser(Mockito.any(User.class));
	}

	@Test
	void testGetUserById() throws Exception {
		User user = new User(11L, "Mario", "Rossi", "Roma", 25, "mario.rossi@example.com", "qwerty");

		when(userService.findUser(11L)).thenReturn(user);

		mockMvc.perform(get("/api/users/11"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.firstname").value("Mario"))
				.andExpect(jsonPath("$.email").value("mario.rossi@example.com"));
		verify(userService, times(1)).findUser(11L);
	}

	@Test
	void testDeleteUser() throws Exception {
		User user = new User(11L, "Mario", "Rossi", "Roma", 25, "mario.rossi@example.com", "qwerty");
		String expectedMessage = "User Mario Rossi deleted!";

		when(userService.findUser(11L)).thenReturn(user);
		when(userService.removeUser(user)).thenReturn(expectedMessage);

		mockMvc.perform(delete("/api/users/11"))
				.andExpect(status().isOk())
				.andExpect(content().string(expectedMessage));

		verify(userService, times(1)).findUser(11L);
		verify(userService, times(1)).removeUser(user);
	}

	@Test
	void testDeleteUserById() throws Exception {
		when(userService.removeUserById(11L)).thenReturn("User deleted!");

		mockMvc.perform(delete("/api/users/11/delete"))
				.andExpect(content().string("User deleted!"));

		verify(userService, times(1)).removeUserById(11L);
	}

	@Test
	void testPutUpdateUser() throws Exception {
		User user = new User(11L, "Mario", "Rossi", "Roma", 25, "mario.rossi@example.com", "qwerty");
		User userSave = new User(11L, "Mario", "Rossi", "Palermo", 25, "m.rossi@example.com", "qwerty");

		when(userService.findUser(11L)).thenReturn(user);
		when(userService.saveUser(Mockito.any(User.class))).thenReturn(userSave);

		mockMvc.perform(put("/api/users/11")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(userSave)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(user.getId()))
				.andExpect(jsonPath("$.city").value("Palermo"))
				.andExpect(jsonPath("$.email").value("m.rossi@example.com"));

		verify(userService, times(1)).findUser(11L);
		verify(userService, times(1)).saveUser(Mockito.any(User.class));
	}

	@Test
	void testPatchUpdateUser() throws Exception {
		User user = new User(11L, "Mario", "Rossi", "Palermo", 25, "m.rossi@example.com", "qwerty");
		User userSave = new User(11L, "Mario", "Rossi", "Palermo", 25, "test@example.com", "Pa$$w0rd!");

		Map<String, Object> updates = new HashMap<String, Object>();
		updates.put("email", "test@example.com");
		updates.put("password", "Pa$$w0rd!");

		when(userService.findUser(11L)).thenReturn(user);
		when(userService.saveUser(Mockito.any(User.class))).thenReturn(userSave);

		mockMvc.perform(patch("/api/users/11")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(updates)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(user.getId()))
				.andExpect(jsonPath("$.password").value("Pa$$w0rd!"))
				.andExpect(jsonPath("$.email").value("test@example.com"));

		verify(userService, times(1)).findUser(11L);
		verify(userService, times(1)).saveUser(Mockito.any(User.class));
	}
}
