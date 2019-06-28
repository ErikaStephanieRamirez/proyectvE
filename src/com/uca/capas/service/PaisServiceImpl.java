package com.uca.capas.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Pais;
import com.uca.capas.repository.PaisRepository;

@Service
public class PaisServiceImpl implements PaisService{

	@PersistenceContext(name = "persistencia")
	EntityManager entitymanager;
	
	@Autowired
	PaisRepository paisrepository;
	
	@Override
	public Pais findById(Integer id) {
		// TODO Auto-generated method stub
		return paisrepository.getOne(id);
	}

	@Override
	public List<Pais> findAll() {
		// TODO Auto-generated method stub
		return paisrepository.findAll();
	}
}
