package com.uca.capas.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema= "public", name = "municipio")
public class Municipio {

	@Id
	@GeneratedValue(generator = "municipio_sk_municipio_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "municipio_sk_municipio_seq", sequenceName = "public.municipio_sk_municipio_seq", allocationSize = 1)
	@Column(name = "sk_municipio")
	private Integer sk_municipio;
	
	@Column(name = "municipio")//50 max
	private String municipio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sk_departamento")
	private Departamento departamento;

	@OneToMany(mappedBy = "municipio", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
	private List<Usuario> usuarios;
	
	public Municipio() {
		super();
	}

	public Municipio(Integer sk_municipio, String municipio, Departamento departamento, List<Usuario> usuarios) {
		super();
		this.sk_municipio = sk_municipio;
		this.municipio = municipio;
		this.departamento = departamento;
		this.usuarios = usuarios;
	}

	public Integer getSk_municipio() {
		return sk_municipio;
	}

	public void setSk_municipio(Integer sk_municipio) {
		this.sk_municipio = sk_municipio;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
}
