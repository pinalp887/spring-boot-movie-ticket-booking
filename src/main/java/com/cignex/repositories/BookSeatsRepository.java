package com.cignex.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cignex.entities.Show;

@Repository("bookSeatsRepository")
public interface BookSeatsRepository extends JpaRepository<Show, Integer> {
	@Modifying
	@Query("update Show s SET s.bookedSeats = :arr WHERE s.id = :id")
	int updateBookSeat(@Param("id") int id, @Param("arr") String arr[]);

	@Query(value = "Select s from Show s where s.movie.id= :id and s.date= :date")
	List<Show> findByIdAndDate(@Param("id") int id, @Param("date") Date date);

}
