package com.uca.capas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento,Integer>{
	
	public List<Departamento> findAll();

}