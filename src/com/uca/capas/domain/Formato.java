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
@Table(schema= "public", name = "formato")
public class Formato {

	@Id
	@GeneratedValue(generator = "formato_sk_formato_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "formato_sk_formato_seq", sequenceName = "public.formato_sk_formato_seq", allocationSize = 1)
	@Column(name = "sk_formato")
	private Integer sk_formato;
	
	@Column(name = "formato")// 40 maximo
	private String formato;
	
	@Column(name = "ak_formato")// 10 maximo
	private String ak_formato;
	
	@OneToMany(mappedBy = "formato", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
	private List<Funcion> funciones;

	public Formato() {
		super();
	}

	public Formato(Integer sk_formato, String formato, String ak_formato, List<Funcion> funciones) {
		super();
		this.sk_formato = sk_formato;
		this.formato = formato;
		this.ak_formato = ak_formato;
		this.funciones = funciones;
	}

	public Integer getSk_formato() {
		return sk_formato;
	}

	public void setSk_formato(Integer sk_formato) {
		this.sk_formato = sk_formato;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getAk_formato() {
		return ak_formato;
	}

	public void setAk_formato(String ak_formato) {
		this.ak_formato = ak_formato;
	}

	public List<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(List<Funcion> funciones) {
		this.funciones = funciones;
	}
}
