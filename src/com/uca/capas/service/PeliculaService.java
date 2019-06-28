package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Pelicula;
import com.uca.capas.dto.EditarPeliculaDTO;

public interface PeliculaService {
	
	public List<Pelicula> findAll();
	
	public Pelicula getById(Integer id);
	
	public void inactivarPelicula(Integer id);
	
	public void activarPelicula(Integer id);
	
	public EditarPeliculaDTO getPeliculaDTO(Integer id);
	
	public void actualizarPelicula(EditarPeliculaDTO dto);
	
	public void agregarPelicula(EditarPeliculaDTO dto);

}
