package com.memorynotfound.spring.security.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

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
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Classe que representa o usuario do sistema
 * 
 * @author oscarq
 *
 */
@Entity
public class Auto implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	@NotEmpty
	@Size(max = 50)
	private String nombre;

	@Column
	@NotEmpty
	private String tipo;
	
	@Column
	@NotEmpty
	private String transmision;
	
	@Column
	@NotEmpty
	private String categoria;
	
	@Column
	@NotEmpty
	private String pasajeros;
	
	@Column
	@NotEmpty
	private Double precio;
	
	@Column
	@NotEmpty
	private Integer cantidad;

	@Column
	@NotEmpty
	private Integer capacidad;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="auto", cascade = CascadeType.ALL)
    private Set<Reserva> reservas;
	
	@Column
	@NotEmpty
	private String aireAcondicionado;
	
	@Column
	@NotEmpty
	private String tipoAsiento;
	
	@Column
	@NotEmpty
	private String radio;
	
	@Column
	@NotEmpty
	private Integer puertoUsb;
	
	@Column
	@NotEmpty
	private String camaraRetro;
	
	@Column
	@NotEmpty
	private String interCol;
	
	@Column
	@NotEmpty
	private String cntrlVoz;
	
	@Column
	@NotEmpty
	private String bluetooth;
	
	@Column
	@NotEmpty
	private String encendidoAuto;
	
	@Column
	@NotEmpty
	private String sistNav;
	
	@Column
	@NotEmpty
	private Double seguroVehiculo;
	
	@Transient
	private boolean disponible;
	

	public Auto() {
	}
	
	public Auto(Long id, String nombre, String tipo, String transmision, String categoria, String pasajeros,
			Double precio, Integer cantidad, Integer capacidad, Set<Reserva> reservas, String aireAcondicionado,
			String tipoAsiento, String radio, Integer puertoUsb, String camaraRetro, String interCol, String cntrlVoz,
			String bluetooth, String encendidoAuto, String sistNav, Double seguroVehiculo, boolean disponible) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.transmision = transmision;
		this.categoria = categoria;
		this.pasajeros = pasajeros;
		this.precio = precio;
		this.cantidad = cantidad;
		this.capacidad = capacidad;
		this.reservas = reservas;
		this.aireAcondicionado = aireAcondicionado;
		this.tipoAsiento = tipoAsiento;
		this.radio = radio;
		this.puertoUsb = puertoUsb;
		this.camaraRetro = camaraRetro;
		this.interCol = interCol;
		this.cntrlVoz = cntrlVoz;
		this.bluetooth = bluetooth;
		this.encendidoAuto = encendidoAuto;
		this.sistNav = sistNav;
		this.seguroVehiculo = seguroVehiculo;
		this.disponible = disponible;
	}





	public String getAireAcondicionado() {
		return aireAcondicionado;
	}





	public void setAireAcondicionado(String aireAcondicionado) {
		this.aireAcondicionado = aireAcondicionado;
	}





	public String getTipoAsiento() {
		return tipoAsiento;
	}





	public void setTipoAsiento(String tipoAsiento) {
		this.tipoAsiento = tipoAsiento;
	}





	public String getRadio() {
		return radio;
	}





	public void setRadio(String radio) {
		this.radio = radio;
	}





	public Integer getPuertoUsb() {
		return puertoUsb;
	}





	public void setPuertoUsb(Integer puertoUsb) {
		this.puertoUsb = puertoUsb;
	}





	public String getCamaraRetro() {
		return camaraRetro;
	}





	public void setCamaraRetro(String camaraRetro) {
		this.camaraRetro = camaraRetro;
	}





	public String getInterCol() {
		return interCol;
	}





	public void setInterCol(String interCol) {
		this.interCol = interCol;
	}





	public String getCntrlVoz() {
		return cntrlVoz;
	}





	public void setCntrlVoz(String cntrlVoz) {
		this.cntrlVoz = cntrlVoz;
	}





	public String getBluetooth() {
		return bluetooth;
	}





	public void setBluetooth(String bluetooth) {
		this.bluetooth = bluetooth;
	}





	public String getEncendidoAuto() {
		return encendidoAuto;
	}





	public void setEncendidoAuto(String encendidoAuto) {
		this.encendidoAuto = encendidoAuto;
	}





	public String getSistNav() {
		return sistNav;
	}





	public void setSistNav(String sistNav) {
		this.sistNav = sistNav;
	}





	public Double getSeguroVehiculo() {
		return seguroVehiculo;
	}





	public void setSeguroVehiculo(Double seguroVehiculo) {
		this.seguroVehiculo = seguroVehiculo;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getTransmision() {
		return transmision;
	}


	public void setTransmision(String transmision) {
		this.transmision = transmision;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getPasajeros() {
		return pasajeros;
	}


	public void setPasajeros(String pasajeros) {
		this.pasajeros = pasajeros;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public Integer getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	

	public Set<Reserva> getReservas() {
		return reservas;
	}


	public void setReservas(Set<Reserva> reservas) {
		this.reservas = reservas;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public boolean isDisponible() {
		return disponible;
	}


	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}


	@Override
	public String toString() {
		return "Auto [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", transmision=" + transmision
				+ ", categoria=" + categoria + ", pasajeros=" + pasajeros + ", precio=" + precio + ", cantidad="
				+ cantidad + ", capacidad=" + capacidad + ", reservas=" + reservas + ", aireAcondicionado="
				+ aireAcondicionado + ", tipoAsiento=" + tipoAsiento + ", radio=" + radio + ", puertoUsb=" + puertoUsb
				+ ", camaraRetro=" + camaraRetro + ", interCol=" + interCol + ", cntrlVoz=" + cntrlVoz + ", bluetooth="
				+ bluetooth + ", encendidoAuto=" + encendidoAuto + ", sistNav=" + sistNav + ", seguroVehiculo="
				+ seguroVehiculo + ", disponible=" + disponible + "]";
	}
	
	
	
}
