package com.cignex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cignex.entities.User;

public interface RegistrationRepository extends JpaRepository<User, Integer> {

	User findByName(String username);

}
