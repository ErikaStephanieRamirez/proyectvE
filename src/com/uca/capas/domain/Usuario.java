package com.uca.capas.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
@Table(schema= "public", name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(generator = "usuario_id_usuario_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "usuario_id_usuario_seq", sequenceName = "public.usuario_id_usuario_seq", allocationSize = 1)
	@Column(name = "id_usuario")
	private Integer id_usuario;
	
	@Column(name = "nomusuario")//20 maximo
	private String nomusuario;
	
	@Column(name = "pasword")//20 maximo
	private String pasword;
	
	@Column(name = "nombre")//20 maximo
	private String nombre;
	
	@Column(name = "apellido")//20 maximo
	private String apellido;
	
	//@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "fechanac")//20 maximo
	private Date fechanac;
	
	@Column(name = "direccion")//50 maximo
	private String direccion;
	
	@Column(name = "saldo")
	private BigDecimal saldo;
	
	@Column(name = "estado_usuario")
	private Boolean estado_usuario;
	
	@Column(name = "tipo_usuario")
	private Boolean tipo_usuario;
	
	@Column(name = "descripcion_usuario")//500 maximo
	private String descripcion_usuario;
	
	@Column(name = "inicio_sesion")
	private Boolean inicio_sesion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sk_pais")
	private Pais pais;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sk_departamento")
	private Departamento departamento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sk_municipio")
	private Municipio municipio;	
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
	private List<Reserva> reservas;

	public Usuario() {
		super();
	}

	public Usuario(Integer id_usuario, String nomusuario, String pasword, String nombre, String apellido, Date fechanac,
			String direccion, BigDecimal saldo, Boolean estado_usuario, Boolean tipo_usuario,
			String descripcion_usuario, Boolean inicio_sesion, Pais pais, Departamento departamento, Municipio municipio,
			List<Reserva> reservas) {
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
		this.pais = pais;
		this.departamento = departamento;
		this.reservas = reservas;
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

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	//Delegate Nombre Completo
	public String getNombreCompleto() {
		String nombreCompleto = null;
		if(this.nombre == null && this.apellido == null) {
			return "";
		} else {
			nombreCompleto = this.nombre + " " + this.apellido;
		}
		return nombreCompleto;
	}
	
	//Delegate Nombre Completo
	public String getEstadoDelegate() {
		String estado = null;
		if(this.estado_usuario == null) {
			return "";
		} else if (this.estado_usuario == true) {
			estado = "Activo";
		} else {
			estado = "Inactivo";
		}
		return estado;
	}
	
	public String getFechaDelegate(){
		if(this.fechanac == null){
			return "";
		}
		else{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String shortdate = sdf.format(this.fechanac.getTime());
			return shortdate;
		}
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	
}
