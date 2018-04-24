package com.memorynotfound.spring.security.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Classe que representa o usuario do sistema
 * 
 * @author oscarq
 *
 */
@Entity
public class Reserva implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(optional=false)
    @JoinColumn(name="id_auto", referencedColumnName="id")
    private Auto auto;
	
	@ManyToOne(optional=false)
    @JoinColumn(name="id_userinfo", referencedColumnName="id")
    private UserInfo userInfo;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column
	@NotNull
	private LocalDate fechaReservaIni;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column
	@NotNull
	private LocalDate fechaReservaFin;
	
	@Column
	private Double precio;
	
	@Column
	@NotEmpty
	private String estado;

	public Reserva() {
	}


	public Reserva(Long id, Auto auto, UserInfo userInfo, LocalDate fechaReservaIni, LocalDate fechaReservaFin,
			Double precio, String estado) {
		super();
		this.id = id;
		this.auto = auto;
		this.userInfo = userInfo;
		this.fechaReservaIni = fechaReservaIni;
		this.fechaReservaFin = fechaReservaFin;
		this.precio = precio;
		this.estado = estado;
	}




	public LocalDate getFechaReservaIni() {
		return fechaReservaIni;
	}




	public void setFechaReservaIni(LocalDate fechaReservaIni) {
		this.fechaReservaIni = fechaReservaIni;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Auto getAuto() {
		return auto;
	}


	public void setAuto(Auto auto) {
		this.auto = auto;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public LocalDate getFechaReservaFin() {
		return fechaReservaFin;
	}

	public void setFechaReservaFin(LocalDate fechaReservaFin) {
		this.fechaReservaFin = fechaReservaFin;
	}
	
}
