package com.java.spring.dojosAndNinjas.services;

import org.springframework.stereotype.Service;

import com.java.spring.dojosAndNinjas.models.Ninja;
import com.java.spring.dojosAndNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
private NinjaRepository ninjaRepository;
	
	public NinjaService ( NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public void createNinja(Ninja ninja ) {
		ninjaRepository.save(ninja);
	}
}
