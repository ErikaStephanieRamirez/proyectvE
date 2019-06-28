package com.uca.capas.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema= "public", name = "pais")
public class Pais {

	@Id
	@GeneratedValue(generator = "pais_sk_pais_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "pais_sk_pais_seq", sequenceName = "public.pais_sk_pais_seq", allocationSize = 1)
	@Column(name = "sk_pais")
	private Integer sk_pais;
	
	@Column(name = "pais")
	private String pais;
	
	@Column(name = "ak_pais")
	private String ak_pais;
	
	@OneToMany(mappedBy = "pais", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
	private List<Usuario> usuarios;

	public Pais() {
		super();
	}

	public Pais(Integer sk_pais, String pais, String ak_pais, List<Usuario> usuarios) {
		super();
		this.sk_pais = sk_pais;
		this.pais = pais;
		this.ak_pais = ak_pais;
		this.usuarios = usuarios;
	}

	public Integer getSk_pais() {
		return sk_pais;
	}

	public void setSk_pais(Integer sk_pais) {
		this.sk_pais = sk_pais;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getAk_pais() {
		return ak_pais;
	}

	public void setAk_pais(String ak_pais) {
		this.ak_pais = ak_pais;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
}
