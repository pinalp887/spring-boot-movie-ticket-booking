package com.cignex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cignex.entities.Screen;

@Repository("screenRepository")
public interface ScreenRepository extends JpaRepository<Screen, Integer> {

}
