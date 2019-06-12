package org.mvpigs.cotxox.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "Conductor")
public class Conductor {

	@Id
	@SequenceGenerator(name = "conductor_id_seq", sequenceName = "conductor_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String co_tarjeta;
	
	@Column(name = "nombre")
	private String co_nombre = null;
	
	@Column(name = "modelo")
	private String co_modelo = null;
	
	@Column(name = "matricula")
	private String co_matricula = null;
	
	@Column(name = "valoracion_media")
	private double co_valoracionMedia = 0d;
	
	@Column(name = "ocupado")
	private boolean co_ocupado = false;
	
	@Column(name = "valoraciones")
	private ArrayList<Byte> co_valoraciones = new ArrayList<>();
	
	@Column(name = "carreras")
	private Set<Carrera> co_carreras = new HashSet<>();

	/**
	 * Constructores: necesitamos el constructor por defecto 
	 * para trabajar con Spring JPA
	 */
		
	public Conductor() {
		
	}
	
	public Conductor(String tarjetaCredito){
		this.co_tarjeta = tarjetaCredito;
	}
		
	/** 
	 * Getters y setters
	 */

	public String getNombre() {
		return this.co_nombre;
	}

	public void setNombre(String co_nombre) {
		this.co_nombre = co_nombre;
	}

	public String getModelo() {
		return this.co_modelo;
	}

	public void setModelo(String co_modelo) {
		this.co_modelo = co_modelo;
	}

	public String getMatricula() {
		return this.co_matricula;
	}

	public void setMatricula(String co_matricula) {
		this.co_matricula = co_matricula;
	}

	public double getValoracion() {
		return this.co_valoracionMedia;
	}
	
	public int getNumeroValoraciones(){
		return this.co_valoraciones.size();
	}

	public void setValoracion(byte co_valoracion) {		
		this.co_valoraciones.add(co_valoracion);
		this.calcularValoracionMedia();
	}

	/**
	 * Lógica de la clase
	 */

	private double calcularValoracionMedia(){
		int sumaValoraciones = 0;
		for(byte valoracion : this.valoraciones){
			sumaValoraciones += valoracion;
		}
		this.valoracionMedia = (double) sumaValoraciones / this.valoraciones.size();
		return this.valoracionMedia;
	}
	
	public void setOcupado(Boolean ocupado){
		this.ocupado = ocupado;
	}
	
	public boolean isOcupado(){
		return this.ocupado;
	}

}
