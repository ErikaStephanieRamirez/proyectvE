package com.uca.capas.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Departamento;
import com.uca.capas.domain.Municipio;
import com.uca.capas.domain.Pais;
import com.uca.capas.domain.Usuario;
import com.uca.capas.dto.UsuarioDTO;
import com.uca.capas.repository.DepartamentoRepository;
import com.uca.capas.repository.MunicipioRepository;
import com.uca.capas.repository.PaisRepository;
import com.uca.capas.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepository usuariorepository;
	
	@Autowired
	PaisRepository paisrepository;

	@Autowired
	DepartamentoRepository depRepository;
	
	@Autowired
	MunicipioRepository munRepository;
	
	@PersistenceContext(name = "persistencia")
	EntityManager entitymanager;

	@Override
	public Usuario findUsuarioyContraseña(String user, String pass) {
		// TODO Auto-generated method stub
		return usuariorepository.findUsuarioyContraseña(user, pass);
	}

	@Override
	@Transactional
	public void user_sesion(Boolean sesion,String user, String pass) {
		// TODO Auto-generated method stub
		Usuario usuario = usuariorepository.findUsuarioyContraseña(user, pass);
		usuario.setInicio_sesion(sesion);
		entitymanager.persist(usuario);
		entitymanager.flush();
	}

	@Override
	public List<Usuario> findUsers() {
		// TODO Auto-generated method stub
		return usuariorepository.findUsers();
	}

	@Override
	public Usuario getById(Integer id) {
		// TODO Auto-generated method stub
		return usuariorepository.getOne(id);
	}

	@Override
	@Transactional
	public void inactivarUsuario(Integer id, String msg) {
		// TODO Auto-generated method stub
		Usuario user = usuariorepository.getOne(id);
		user.setEstado_usuario(false);
		user.setDescripcion_usuario(msg);
		entitymanager.merge(user);
		entitymanager.flush();
	}

	@Override
	@Transactional
	public void activarUsuario(Integer id) {
		// TODO Auto-generated method stub
		Usuario user = usuariorepository.getOne(id);
		user.setEstado_usuario(true);
		entitymanager.merge(user);
		entitymanager.flush();
	}
	
	
	//=====================nuevo=================

	@Override
	public Usuario add(Usuario u) {
		// TODO Auto-generated method stub
		//Usuario user = 
		
		return usuariorepository.save(u);
	}

	@Override
	public UsuarioDTO Asociar() throws DataAccessException {
		// TODO Auto-generated method stub
		UsuarioDTO u = new UsuarioDTO();
		return u;
	}
	
	@Override
	@Transactional
	public int agregar(UsuarioDTO u)  throws ParseException{
		
		Pais p = paisrepository.findById(u.getId_pais()).get();
		
		Departamento d;
		
		if(u.getId_departamento()==null) {
			d=null;
		}else {
		 d = depRepository.findById(u.getId_departamento()).get();
		}
		
		Municipio m;
		
		if(u.getId_municipio() == null) {
			m=null;
		}else {
		 m = munRepository.findById(u.getId_municipio()).get();
		}
		Usuario user = new Usuario();
		
		double billete = 20;
		
		user.setNomusuario(u.getNomusuario());
		user.setPasword(u.getPasword());
		user.setNombre(u.getNombre());
		user.setApellido(u.getApellido());
		user.setFechanac(u.getFechanac());
		user.setDireccion(u.getDireccion());
		user.setPais(p);
		user.setDepartamento(d);
		user.setMunicipio(m);
		user.setEstado_usuario(false);
		user.setInicio_sesion(false);
		user.setSaldo(BigDecimal.valueOf(billete));
		user.setTipo_usuario(false);
		entitymanager.persist(user);
		entitymanager.flush();
		return 1;
	}
}
