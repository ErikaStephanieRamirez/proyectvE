package com.uca.capas.domain;

import java.math.BigInteger;
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
@Table(schema= "public", name = "pelicula")
public class Pelicula {

	@Id
	@GeneratedValue(generator = "pelicula_id_pelicula_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "pelicula_id_pelicula_seq", sequenceName = "public.pelicula_id_pelicula_seq", allocationSize = 1)
	@Column(name = "id_pelicula")
	private Integer id_pelicula;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "duracion")
	private BigInteger duracion;
	
	@Column(name = "estado_pel")
	private Boolean estado_pel;
	
	@Column(name = "descripcion")//500 maximo
	private String descripcion;
	
	@Column(name = "image_url")//200 maximo
	private String image_url;
	
	@Column(name = "video_url")//200 maximo
	private String video_url;
	
	@OneToMany(mappedBy = "pelicula", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
	private List<Funcion> funciones;

	public Pelicula() {
		super();
	}

	public Pelicula(Integer id_pelicula, String nombre, BigInteger duracion, Boolean estado_pel, String descripcion,
			String image_url, String video_url, List<Funcion> funciones) {
		super();
		this.id_pelicula = id_pelicula;
		this.nombre = nombre;
		this.duracion = duracion;
		this.estado_pel = estado_pel;
		this.descripcion = descripcion;
		this.image_url = image_url;
		this.video_url = video_url;
		this.funciones = funciones;
	}

	public Integer getId_pelicula() {
		return id_pelicula;
	}

	public void setId_pelicula(Integer id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigInteger getDuracion() {
		return duracion;
	}

	public void setDuracion(BigInteger duracion) {
		this.duracion = duracion;
	}

	public Boolean getEstado_pel() {
		return estado_pel;
	}

	public void setEstado_pel(Boolean estado_pel) {
		this.estado_pel = estado_pel;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getVideo_url() {
		return video_url;
	}

	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}

	public List<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(List<Funcion> funciones) {
		this.funciones = funciones;
	}
	
	//Delegate estado
	public String getEstadoDelegate() {
		String estado = null;
		if(this.estado_pel == null) {
			return "";
		} else if (this.estado_pel == true) {
			estado = "Activo";
		} else {
			estado = "Inactivo";
		}
		return estado;
	}
	
}
