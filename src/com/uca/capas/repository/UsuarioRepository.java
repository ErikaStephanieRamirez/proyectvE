package com.uca.capas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

	@Query(nativeQuery = true, value = "select distinct * "
			+ "from usuario "
			+ "where nomusuario = ?1 and pasword = ?2")
	public Usuario findUsuarioyContraseña(String nomusuario, String pasword);
	
	@Query(nativeQuery = true, value = "select * from usuario where tipo_usuario = false")
	public List<Usuario> findUsers();
	
	
	/*
	@Query(nativeQuery = true, value = "select distinct * "
			+ "from usuario "
			+ "where nomusuario = ?1 and pasword = ?2 and estado_usuario = true and inicio_sesion = false")
	public Usuario findUsuarioyContraseña(String nomusuario, String pasword);*/
}
