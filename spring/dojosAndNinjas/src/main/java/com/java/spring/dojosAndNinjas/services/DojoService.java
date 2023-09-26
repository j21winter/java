package com.java.spring.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.dojosAndNinjas.models.Dojo;
import com.java.spring.dojosAndNinjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	DojoRepository dojoRepository;
	
	public List<Dojo> findAll(){
		return dojoRepository.findAll();
	}
	
	public void createDojo(Dojo dojo) {
		dojoRepository.save(dojo);
	}
	public DojoService() {
		// TODO Auto-generated constructor stub
	}
	
	public Dojo findById(Long id) {
		Optional<Dojo> optionalDojo =  dojoRepository.findById(id);
		if(optionalDojo.isPresent()){
			return optionalDojo.get();
		} else {
			return null;
		}
	}
}
