package com.uca.capas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula,Integer>{
	
	public List<Pelicula> findAll();

}
