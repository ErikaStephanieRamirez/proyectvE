package com.uca.capas.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Pelicula;
import com.uca.capas.dto.EditarPeliculaDTO;
import com.uca.capas.repository.PeliculaRepository;

@Service
public class PeliculaServiceImpl implements PeliculaService{

	@PersistenceContext(name = "persistencia")
	EntityManager entitymanager;
	
	@Autowired
	PeliculaRepository pelicularepository;
	
	@Override
	public List<Pelicula> findAll() {
		// TODO Auto-generated method stub
		return pelicularepository.findAll();
	}

	@Override
	public Pelicula getById(Integer id) {
		// TODO Auto-generated method stub
		return pelicularepository.getOne(id);
	}

	@Override
	@Transactional
	public void inactivarPelicula(Integer id) {
		// TODO Auto-generated method stub
		Pelicula movie = pelicularepository.getOne(id);
		movie.setEstado_pel(false);
		entitymanager.merge(movie);
		entitymanager.flush();
	}

	@Override
	@Transactional
	public void activarPelicula(Integer id) {
		// TODO Auto-generated method stub
		Pelicula movie = pelicularepository.getOne(id);
		movie.setEstado_pel(true);
		entitymanager.merge(movie);
		entitymanager.flush();
	}

	@Override
	public EditarPeliculaDTO getPeliculaDTO(Integer id) {
		// TODO Auto-generated method stub
		Pelicula movie = pelicularepository.getOne(id);
		EditarPeliculaDTO dto = new EditarPeliculaDTO();
		dto.setId_pelicula(movie.getId_pelicula());
		dto.setNombre(movie.getNombre());
		dto.setDuracion(movie.getDuracion());
		dto.setImage_url(movie.getImage_url());
		dto.setVideo_url(movie.getVideo_url());
		dto.setDescripcion(movie.getDescripcion());
		return dto;
	}

	@Override
	@Transactional
	public void actualizarPelicula(EditarPeliculaDTO dto) {
		// TODO Auto-generated method stub
		Pelicula movie = pelicularepository.getOne(dto.getId_pelicula());
		movie.setNombre(dto.getNombre());
		movie.setDuracion(dto.getDuracion());
		movie.setImage_url(dto.getImage_url());
		movie.setVideo_url(dto.getVideo_url());
		movie.setDescripcion(dto.getDescripcion());
		entitymanager.merge(movie);
		entitymanager.flush();
	}

	@Override
	@Transactional
	public void agregarPelicula(EditarPeliculaDTO dto) {
		// TODO Auto-generated method stub
		Pelicula movie = new Pelicula();
		movie.setNombre(dto.getNombre());
		movie.setDuracion(dto.getDuracion());
		movie.setEstado_pel(false);
		movie.setDescripcion(dto.getDescripcion());
		movie.setImage_url(dto.getImage_url());
		movie.setVideo_url(dto.getVideo_url());
		entitymanager.persist(movie);
		entitymanager.flush();
	}

}
