package com.uca.capas.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Municipio;
import com.uca.capas.repository.MunicipioRepository;

@Service
public class MunicipioServiceImpl implements MunicipioService{

	@PersistenceContext(name = "persistencia")
	EntityManager entitymanager;
	
	@Autowired
	MunicipioRepository munRepository;
	
	@Override
	public List<Municipio> findAll() {
		// TODO Auto-generated method stub
		return munRepository.findAll();
	}

	@Override
	public Municipio getById(Integer id) {
		// TODO Auto-generated method stub
		return munRepository.getOne(id);
	}

	@Override
	public List<Municipio> getByIdMun(Integer sk_departamento) {
		// TODO Auto-generated method stub
		return munRepository.findId(sk_departamento);
	}

}
