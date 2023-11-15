/**
 * 
 */
package com.example.demo.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 */
@Entity
@Table(name = "facultades")
public class Facultad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Codigo")
	private Long codigo;

	@Column(name = "Nombre")
	private String nombre;

	@OneToMany
	@JoinColumn(name = "DNI")
	private Set<Investigador> investigador;

	@OneToMany
	@JoinColumn(name = "Num_serie")
	private Set<Equipo> equipo;

	/**
	 * 
	 */
	public Facultad() {
	}

	/**
	 * @param codigo
	 * @param nombre
	 */
	public Facultad(Long codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	/**
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the investigador
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "DNI")
	public Set<Investigador> getInvestigador() {
		return investigador;
	}

	/**
	 * @return the equipo
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Num_serie")
	public Set<Equipo> getEquipo() {
		return equipo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param investigador the investigador to set
	 */
	public void setInvestigador(Set<Investigador> investigador) {
		this.investigador = investigador;
	}

	/**
	 * @param equipo the equipo to set
	 */
	public void setEquipo(Set<Equipo> equipo) {
		this.equipo = equipo;
	}

}
