package com.uca.capas.dto;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@SuppressWarnings("deprecation")
public class EditarPeliculaDTO {

	private Integer id_pelicula;
	
	@NotEmpty(message = "favor ingrese el nombre la pelicula")
	@Size(message = "la longitud maxima es de 50 caracteres", min = 0, max = 50)
	private String nombre;
	
	@NotNull(message="favor ingresar la duracion de la pelicula")
	//@Digits(message = "la pelicula sobrepasa 99,999 minutos", integer = 5, fraction = 0)
	@Range(min = 0, max = 9999, message = "La duracion de la pelicula es muy alta")
	private BigInteger duracion;
	
	@NotEmpty(message = "favor ingrese la imagen")
	@Size(message = "la longitud maxima es de 200 caracteres", min = 0, max = 200)
	private String image_url;
	
	@NotEmpty(message = "favor ingrese el video de la pelicula")
	@Size(message = "la longitud maxima es de 200 caracteres", min = 0, max = 200)
	private String video_url;
	
	@NotEmpty(message = "favor ingrese la descripcion de la pelicula")
	@Size(message = "la longitud maxima es de 500 caracteres", min = 0, max = 500)
	private String descripcion;

	public EditarPeliculaDTO() {
		super();
	}

	public EditarPeliculaDTO(Integer id_pelicula,
			@NotEmpty(message = "favor ingrese el nombre la pelicula") @Size(message = "la longitud maxima es de 50 caracteres", min = 0, max = 50) String nombre,
			@NotNull(message = "favor ingresar la duracion de la pelicula") @Range(min = 0, max = 9999, message = "La duracion de la pelicula es muy alta") BigInteger duracion,
			@NotEmpty(message = "favor ingrese la imagen") @Size(message = "la longitud maxima es de 200 caracteres", min = 0, max = 200) String image_url,
			@NotEmpty(message = "favor ingrese el video de la pelicula") @Size(message = "la longitud maxima es de 200 caracteres", min = 0, max = 200) String video_url,
			@NotEmpty(message = "favor ingrese la descripcion de la pelicula") @Size(message = "la longitud maxima es de 500 caracteres", min = 0, max = 500) String descripcion) {
		super();
		this.id_pelicula = id_pelicula;
		this.nombre = nombre;
		this.duracion = duracion;
		this.image_url = image_url;
		this.video_url = video_url;
		this.descripcion = descripcion;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
