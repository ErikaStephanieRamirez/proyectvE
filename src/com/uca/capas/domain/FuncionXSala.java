package com.uca.capas.domain;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema= "public", name = "funcionxsala")
public class FuncionXSala {

	@Id
	@GeneratedValue(generator = "funcionxsala_id_funxsala_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "funcionxsala_id_funxsala_seq", sequenceName = "public.funcionxsala_id_funxsala_seq", allocationSize = 1)
	@Column(name = "id_funxsala")
	private Integer id_funxsala;
	
	@Column(name = "disponibles_dbox")
	private BigInteger disponibles_dbox;
	
	@Column(name = "disponibles_normal")
	private BigInteger disponibles_normal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_funcion")
	private Funcion funcion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_sala")
	private Sala sala;

	public FuncionXSala() {
		super();
	}

	public FuncionXSala(Integer id_funxsala, BigInteger disponibles_dbox, BigInteger disponibles_normal,
			Funcion funcion, Sala sala) {
		super();
		this.id_funxsala = id_funxsala;
		this.disponibles_dbox = disponibles_dbox;
		this.disponibles_normal = disponibles_normal;
		this.funcion = funcion;
		this.sala = sala;
	}

	public Integer getId_funxsala() {
		return id_funxsala;
	}

	public void setId_funxsala(Integer id_funxsala) {
		this.id_funxsala = id_funxsala;
	}

	public BigInteger getDisponibles_dbox() {
		return disponibles_dbox;
	}

	public void setDisponibles_dbox(BigInteger disponibles_dbox) {
		this.disponibles_dbox = disponibles_dbox;
	}

	public BigInteger getDisponibles_normal() {
		return disponibles_normal;
	}

	public void setDisponibles_normal(BigInteger disponibles_normal) {
		this.disponibles_normal = disponibles_normal;
	}

	public Funcion getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	
}
