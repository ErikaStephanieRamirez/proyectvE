package com.uca.capas.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Usuario;

import com.uca.capas.dto.UsuarioDTO;

public interface UsuarioService {

	public Usuario findUsuarioyContraseña(String user, String pass);
	
	public void user_sesion(Boolean sesion, String username, String password);
	
	public List<Usuario> findUsers();
	
	public Usuario getById(Integer id);
	
	public void inactivarUsuario(Integer id, String msg);
	
	public void activarUsuario(Integer id);
	
	public Usuario add(Usuario u); 

	public UsuarioDTO Asociar() throws DataAccessException;
	
	public int agregar(UsuarioDTO u)  throws ParseException;
	
}
