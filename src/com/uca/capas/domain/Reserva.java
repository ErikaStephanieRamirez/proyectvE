package com.uca.capas.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;

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
@Table(schema= "public", name = "reserva")
public class Reserva {

	@Id
	@GeneratedValue(generator = "reserva_id_reserva_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "reserva_id_reserva_seq", sequenceName = "public.reserva_id_reserva_seq", allocationSize = 1)
	@Column(name = "id_reserva")
	private Integer id_reserva;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "gran_total")
	private BigDecimal gran_total;
	
	@Column(name = "sub_total")
	private BigDecimal sub_total;
	
	@Column(name = "total_cuenta")
	private BigDecimal total_cuenta;
	
	@Column(name = "total_asientos")
	private BigInteger total_asientos;
	
	@Column(name = "tipo_asientos")//20 max
	private String tipo_asientos;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_funcion")
	private Funcion funcion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Reserva() {
		super();
	}

	public Reserva(Integer id_reserva, Date fecha, BigDecimal gran_total, BigDecimal sub_total, BigDecimal total_cuenta,
			BigInteger total_asientos, String tipo_asientos, Funcion funcion, Usuario usuario) {
		super();
		this.id_reserva = id_reserva;
		this.fecha = fecha;
		this.gran_total = gran_total;
		this.sub_total = sub_total;
		this.total_cuenta = total_cuenta;
		this.total_asientos = total_asientos;
		this.tipo_asientos = tipo_asientos;
		this.funcion = funcion;
		this.usuario = usuario;
	}

	public Integer getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(Integer id_reserva) {
		this.id_reserva = id_reserva;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getGran_total() {
		return gran_total;
	}

	public void setGran_total(BigDecimal gran_total) {
		this.gran_total = gran_total;
	}

	public BigDecimal getSub_total() {
		return sub_total;
	}

	public void setSub_total(BigDecimal sub_total) {
		this.sub_total = sub_total;
	}

	public BigDecimal getTotal_cuenta() {
		return total_cuenta;
	}

	public void setTotal_cuenta(BigDecimal total_cuenta) {
		this.total_cuenta = total_cuenta;
	}

	public BigInteger getTotal_asientos() {
		return total_asientos;
	}

	public void setTotal_asientos(BigInteger total_asientos) {
		this.total_asientos = total_asientos;
	}

	public String getTipo_asientos() {
		return tipo_asientos;
	}

	public void setTipo_asientos(String tipo_asientos) {
		this.tipo_asientos = tipo_asientos;
	}

	public Funcion getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
