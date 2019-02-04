package com.cignex.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.cignex.entities.Screen;
import com.cignex.exception.ScreenNotFoundException;
import com.cignex.repositories.ScreenRepository;

@Service("screenService")
public class ScreenService {
	Screen screen=null;
	@Autowired
	private ScreenRepository screenRepository;
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void save(Screen screen) {
		screenRepository.save(screen);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<Screen> getAllList() {
		return screenRepository.findAll();
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Screen getScreenById(int id) {
		try {
			screen= screenRepository.findById(id).get();

		} catch (NoSuchElementException e) {
			throw new ScreenNotFoundException(" screen is not found with id " +id);
		}
		return screen;

	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(Screen screen) {
		screenRepository.delete(screen);
	}
}
