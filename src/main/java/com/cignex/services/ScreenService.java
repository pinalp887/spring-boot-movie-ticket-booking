package com.cignex.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cignex.entities.Screen;
import com.cignex.repositories.ScreenRepository;

@Service("screenService")
public class ScreenService {
	@Autowired
	private ScreenRepository screenRepository;
	
	public void save(Screen screen) {
		screenRepository.save(screen);
	}
	
	public List<Screen> getAllList(){
		return screenRepository.findAll();
	}
	public Screen getScreenById(int id) {
		return screenRepository.findById(id).get();
	}
	public void delete(Screen screen) {
		screenRepository.delete(screen);
	}
}
