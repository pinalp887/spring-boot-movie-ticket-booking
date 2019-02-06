package com.cignex.services;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cignex.entities.Show;
import com.cignex.exception.ShowNotFoundException;
import com.cignex.repositories.BookSeatsRepository;

@Service("bookSeatsService")
public class BookSeatsService {
	@Autowired
	private BookSeatsRepository bookSeatsRepository;

	public void save(Show seats) {
		bookSeatsRepository.save(seats);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public List<Show> getAllShows() {
		List<Show> list = bookSeatsRepository.findAll();
		return list;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public Show getShowById(int id) {
		Show seats=null;
		try {
			seats = bookSeatsRepository.getOne(id);
		} catch (EntityNotFoundException e) {
				throw new ShowNotFoundException("There were no show founded with id "+id);
		}
		return seats;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(int id) {
		Show bookSeats = bookSeatsRepository.getOne(id);
		bookSeatsRepository.delete(bookSeats);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public List<Show> getMovieByDate(int id, java.sql.Date date) {
		return bookSeatsRepository.findByIdAndDate(id, date);
	}

	@Transactional
	public int upShowById(int id, String arr[]) {
		int i = bookSeatsRepository.updateBookSeat(id, arr);
		return i;
	}
}
