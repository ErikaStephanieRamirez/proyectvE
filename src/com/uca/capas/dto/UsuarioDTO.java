package com.uca.capas.dto;

import java.math.BigDecimal;
import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
public class UsuarioDTO {

	private Integer id_usuario;

	@NotEmpty(message = "favor ingrese el nombre de usuario")
	@Size(message = "la longitud maxima es de 30 caracteres", min = 0, max = 30)
	private String nomusuario;
	
	@NotEmpty(message = "favor ingrese la clave")
	@Size(message = "la longitud maxima es de 30 caracteres", min = 0, max = 30)
	private String pasword;
	
	@NotEmpty(message = "favor ingrese el nombre")
	private String nombre;
	
	@NotEmpty(message = "favor ingrese el apellido")
	private String apellido;
	
	@NotNull(message = "favor ingresar una fecha")
	private Date fechanac;
	
	@NotEmpty(message = "favor ingrese la direccion")
	private String direccion;
	
	private BigDecimal saldo;
	
	private Boolean estado_usuario;
	
	private Boolean tipo_usuario;
	
	private String descripcion_usuario;
	
	private Boolean inicio_sesion;
	
	@NotNull(message="favor seleccionar un pais")
	private Integer id_pais;
	
	private String ak_pais;
	
	private Integer id_departamento;
	
	
	private Integer id_municipio;

	
	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(Integer id_usuario,
			@NotEmpty(message = "favor ingrese el nombre de usuario") @Size(message = "la longitud maxima es de 30 caracteres", min = 0, max = 30) String nomusuario,
			@NotEmpty(message = "favor ingrese la clave") @Size(message = "la longitud maxima es de 50 caracteres", min = 0, max = 30) String pasword,
			@NotEmpty(message = "favor ingrese el nombre") String nombre,
			@NotEmpty(message = "favor ingrese el apellido") String apellido,
			@NotNull(message = "favor ingresar una fecha") Date fechanac,
			@NotEmpty(message = "favor ingrese la direccion") String direccion, BigDecimal saldo,
			Boolean estado_usuario, Boolean tipo_usuario, String descripcion_usuario, Boolean inicio_sesion,
			@NotNull(message="favor seleccionar un pais") Integer id_pais, String ak_pais, Integer id_departamento, Integer id_municipio) {
		super();
		this.id_usuario = id_usuario;
		this.nomusuario = nomusuario;
		this.pasword = pasword;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanac = fechanac;
		this.direccion = direccion;
		this.saldo = saldo;
		this.estado_usuario = estado_usuario;
		this.tipo_usuario = tipo_usuario;
		this.descripcion_usuario = descripcion_usuario;
		this.inicio_sesion = inicio_sesion;
		this.id_pais = id_pais;
		this.ak_pais = ak_pais;
		this.id_departamento = id_departamento;
		this.id_municipio = id_municipio;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNomusuario() {
		return nomusuario;
	}

	public void setNomusuario(String nomusuario) {
		this.nomusuario = nomusuario;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechanac() {
		return fechanac;
	}

	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Boolean getEstado_usuario() {
		return estado_usuario;
	}

	public void setEstado_usuario(Boolean estado_usuario) {
		this.estado_usuario = estado_usuario;
	}

	public Boolean getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(Boolean tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public String getDescripcion_usuario() {
		return descripcion_usuario;
	}

	public void setDescripcion_usuario(String descripcion_usuario) {
		this.descripcion_usuario = descripcion_usuario;
	}

	public Boolean getInicio_sesion() {
		return inicio_sesion;
	}

	public void setInicio_sesion(Boolean inicio_sesion) {
		this.inicio_sesion = inicio_sesion;
	}

	public Integer getId_pais() {
		return id_pais;
	}

	public void setId_pais(Integer id_pais) {
		this.id_pais = id_pais;
	}

	public Integer getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(Integer id_departamento) {
		this.id_departamento = id_departamento;
	}

	public String getSk_pais() {
		return ak_pais;
	}

	public void setSk_pais(String ak_pais) {
		this.ak_pais = ak_pais;
	}

	public String getAk_pais() {
		return ak_pais;
	}

	public void setAk_pais(String ak_pais) {
		this.ak_pais = ak_pais;
	}

	public Integer getId_municipio() {
		return id_municipio;
	}

	public void setId_municipio(Integer id_municipio) {
		this.id_municipio = id_municipio;
	}


}
