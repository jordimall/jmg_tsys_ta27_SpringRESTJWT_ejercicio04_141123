/**
 * 
 */
package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 */
@Entity
@Table(name = "equipos")
public class Equipo {

	@Id
	@Column(name = "Num_serie")
	private String numSerie;

	@Column(name = "Nombre")
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "Facultad")
	private Facultad facultad;

	@OneToMany
	@JoinColumn(name = "Num_serie")
	private List<Reserva> reserva;

	/**
	 * 
	 */
	public Equipo() {
	}

	/**
	 * @param numSerie
	 * @param nombre
	 * @param facultad
	 */
	public Equipo(String numSerie, String nombre, Facultad facultad) {
		this.numSerie = numSerie;
		this.nombre = nombre;
		this.facultad = facultad;
	}

	/**
	 * @return the numSerie
	 */
	public String getNumSerie() {
		return numSerie;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the facultad
	 */
	public Facultad getFacultad() {
		return facultad;
	}

	/**
	 * @return the reserva
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Num_serie")
	public List<Reserva> getReserva() {
		return reserva;
	}

	/**
	 * @param numSerie the numSerie to set
	 */
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param facultad the facultad to set
	 */
	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	/**
	 * @param reserva the reserva to set
	 */
	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

}
