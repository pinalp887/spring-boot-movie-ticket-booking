package com.cignex.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cignex.entities.UserBooked;

@Repository
public interface UserBookedRepository extends JpaRepository<UserBooked, Integer> {
	@Query("Select u from UserBooked u where user.id= :id")
	List<UserBooked> findAllById(@Param("id") int id);

}
