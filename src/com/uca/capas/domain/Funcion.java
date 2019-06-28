package com.uca.capas.domain;


import java.sql.Date;
import java.sql.Time;
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
@Table(schema= "public", name = "funcion")
public class Funcion {

	@Id
	@GeneratedValue(generator = "funcion_id_funcion_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "funcion_id_funcion_seq", sequenceName = "public.funcion_id_funcion_seq", allocationSize = 1)
	@Column(name = "id_funcion")
	private Integer id_funcion;
	
	@Column(name = "hora")
	private Time hora;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "estado_funcion")
	private Boolean estado_funcion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pelicula")
	private Pelicula pelicula;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sk_formato")
	private Formato formato;
	
	@OneToMany(mappedBy = "funcion", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
	private List<Reserva> reservas;
	
	@OneToMany(mappedBy = "funcion", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
	private List<FuncionXSala> funcionxsala;

	public Funcion() {
		super();
	}

	public Funcion(Integer id_funcion, Time hora, Date fecha, Boolean estado_funcion, Pelicula pelicula,
			Formato formato, List<Reserva> reservas, List<FuncionXSala> funcionxsala) {
		super();
		this.id_funcion = id_funcion;
		this.hora = hora;
		this.fecha = fecha;
		this.estado_funcion = estado_funcion;
		this.pelicula = pelicula;
		this.formato = formato;
		this.reservas = reservas;
		this.funcionxsala = funcionxsala;
	}

	public Integer getId_funcion() {
		return id_funcion;
	}

	public void setId_funcion(Integer id_funcion) {
		this.id_funcion = id_funcion;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Boolean getEstado_funcion() {
		return estado_funcion;
	}

	public void setEstado_funcion(Boolean estado_funcion) {
		this.estado_funcion = estado_funcion;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Formato getFormato() {
		return formato;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public List<FuncionXSala> getFuncionxsala() {
		return funcionxsala;
	}

	public void setFuncionxsala(List<FuncionXSala> funcionxsala) {
		this.funcionxsala = funcionxsala;
	}

}
