package com.uca.capas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais,Integer>{
	
	@Query(value ="select p.sk_pais, p.pais, p.ak_pais "
			+ "from public.pais p "
			+ "where p.ak_pais = ?1", nativeQuery = true)
	public Pais findId(String ak_pais);
	
	public List<Pais> findAll();
}
