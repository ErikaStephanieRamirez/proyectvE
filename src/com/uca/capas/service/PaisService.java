package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Pais;

public interface PaisService {

	public List<Pais> findAll();
	
	public Pais findById(Integer id);
	
}
