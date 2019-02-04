package com.cignex.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cignex.entities.User;
import com.cignex.repositories.RegistrationRepository;

@Service("user_service")
public class UserService {
	@Autowired
	private RegistrationRepository repository;

	public User save(User user) {
		return repository.save(user);
	}
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public List<User> getAll() {
		return repository.findAll();
	}
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public User getUserById(int id) {
		return repository.findById(id).get();
	}
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void delete(int id) {
		repository.deleteById(id);
	}

	public String PasswordEncode(String password) {
		String bPass = null;
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		bPass = passwordEncoder.encode(password);
		return bPass;
	}

	public String generate() {
		String generatedString = null;
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 15;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		return generatedString = buffer.toString();
	}

	public User findByName(String username) {
		return repository.findByName(username);
	}
}
