package com.uca.capas.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Departamento;
import com.uca.capas.repository.DepartamentoRepository;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{
	
	@PersistenceContext(name = "persistencia")
	EntityManager entitymanager;
	
	@Autowired
	DepartamentoRepository depRepository;
	
	@Override
	public List<Departamento> findAll() {
		// TODO Auto-generated method stub
		return depRepository.findAll();
	}
	
	@Override
	public Departamento getById(Integer id) {
		// TODO Auto-generated method stub
		return depRepository.getOne(id);
	}
}
