package com.uca.capas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio,Integer>{
	public List<Municipio> findAll();
	
	@Query(value ="select p.sk_municipio, p.municipio, p.ak_municipio, p.sk_departamento "
			+ "from public.municipio p "
			+ "where p.sk_departamento = ?1", nativeQuery = true)
	public List<Municipio> findId(Integer sk_departamento);
}
