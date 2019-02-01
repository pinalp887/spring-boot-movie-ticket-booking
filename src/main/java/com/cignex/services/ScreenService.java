package com.cignex.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.cignex.entities.Screen;
import com.cignex.repositories.ScreenRepository;

@Service("screenService")
public class ScreenService {
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
		return screenRepository.findById(id).get();
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(Screen screen) {
		screenRepository.delete(screen);
	}
}
