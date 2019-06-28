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
@Table(schema= "public", name = "sala")
public class Sala {

	@Id
	@GeneratedValue(generator = "sala_id_sala_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "sala_id_sala_seq", sequenceName = "public.sala_id_sala_seq", allocationSize = 1)
	@Column(name = "id_sala")
	private Integer id_sala;
	
	@Column(name = "sala")// 10 maximo
	private String sala;
	
	@Column(name = "asientos_dbox")
	private BigInteger asientos_dbox;
	
	@Column(name = "asientos_normal")
	private BigInteger asientos_normal;
	
	@OneToMany(mappedBy = "sala", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
	private List<FuncionXSala> funcionxsala;

	public Sala() {
		super();
	}

	public Sala(Integer id_sala, String sala, BigInteger asientos_dbox, BigInteger asientos_normal,
			List<FuncionXSala> funcionxsala) {
		super();
		this.id_sala = id_sala;
		this.sala = sala;
		this.asientos_dbox = asientos_dbox;
		this.asientos_normal = asientos_normal;
		this.funcionxsala = funcionxsala;
	}

	public Integer getId_sala() {
		return id_sala;
	}

	public void setId_sala(Integer id_sala) {
		this.id_sala = id_sala;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public BigInteger getAsientos_dbox() {
		return asientos_dbox;
	}

	public void setAsientos_dbox(BigInteger asientos_dbox) {
		this.asientos_dbox = asientos_dbox;
	}

	public BigInteger getAsientos_normal() {
		return asientos_normal;
	}

	public void setAsientos_normal(BigInteger asientos_normal) {
		this.asientos_normal = asientos_normal;
	}

	public List<FuncionXSala> getFuncionxsala() {
		return funcionxsala;
	}

	public void setFuncionxsala(List<FuncionXSala> funcionxsala) {
		this.funcionxsala = funcionxsala;
	}
	
	
}
