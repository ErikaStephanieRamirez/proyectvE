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
@Table(schema= "public", name = "departamento")
public class Departamento {

	@Id
	@GeneratedValue(generator = "departamento_sk_departamento_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "departamento_sk_departamento_seq", sequenceName = "public.departamento_sk_departamento_seq", allocationSize = 1)
	@Column(name = "sk_departamento")
	private Integer sk_departamento;
	
	@Column(name = "departamento")//50 max
	private String departamento;
	
	@Column(name = "ak_departamento")//5 max
	private String ak_departamento;
	
	@OneToMany(mappedBy = "departamento", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
	private List<Usuario> usuarios;
	
	@OneToMany(mappedBy = "departamento", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
	private List<Municipio> municipios;

	public Departamento() {
		super();
	}

	public Departamento(Integer sk_departamento, String departamento, String ak_departamento, List<Usuario> usuarios,
			List<Municipio> municipios) {
		super();
		this.sk_departamento = sk_departamento;
		this.departamento = departamento;
		this.ak_departamento = ak_departamento;
		this.usuarios = usuarios;
		this.municipios = municipios;
	}

	public Integer getSk_departamento() {
		return sk_departamento;
	}

	public void setSk_departamento(Integer sk_departamento) {
		this.sk_departamento = sk_departamento;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getAk_departamento() {
		return ak_departamento;
	}

	public void setAk_departamento(String ak_departamento) {
		this.ak_departamento = ak_departamento;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}
	
}
