package org.mvpigs.cotxox.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Carrera")
public class Carrera {


	@Id
	@SequenceGenerator(name = "lote_id_seq", sequenceName = "lote_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String tarjetaCredito = null;
	
	@Column(name = "origen")
	private String origen = null;
	
	@Column(name = "destino")
	private String destino = null;
	
	@Column(name = "distancia")
	private double distancia = 0d;
	
	@Column(name = "tiempo_esperado")
	private int tiempoEsperado = 0;
	
	@Column(name =  "tiempo_carrera")
	private int tiempoCarrera = 0;
	
	@Column(name = "coste_total")
	private double costeTotal = 0;
	
	@Column(name = "propina")
	private int propina = 0;
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setPropina(int propina) {
		this.propina = propina;
	}

	@ManyToOne
	private Conductor conductor = null;
	
	/**
	 * Constructores: necesitamos el constructor por defecto 
	 * para trabajar con Spring JPA
	 */

	public Carrera(String tarjetaCredito){
		this.tarjetaCredito = tarjetaCredito;
	}
	
	/** 
	 * Getters y setters
	 */

	public Long getId() {
		return this.id;
	}

	public String getTarjetaCredito(){
		return this.tarjetaCredito;
	}
	
	public void setTarjetaCredito(String tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}
	
	public void setOrigen(String origen){
		this.origen = origen;
	}
	
	public String getOrigen(){
		return this.origen;
	}
	
	public void setDestino(String destino){
		this.destino = destino;
	}
	
	public String getDestino(){
		return this.destino;
	}
	
	public void setDistancia(double distancia){
		this.distancia = distancia;
	}
	
	public double getDistancia(){
		return this.distancia;
	}
	
	public double getCosteEsperado(){
		return Tarifa.getCosteTotalEsperado(this);
	}

	public int getTiempoEsperado() {
		return tiempoEsperado;
	}

	public void setTiempoEsperado(int tiempoEsperado) {
		this.tiempoEsperado = tiempoEsperado;
	}
	
	public int getTiempoCarrera() {
		return tiempoCarrera;
	}

	public void setTiempoCarrera(int tiempoCarrera) {
		this.tiempoCarrera = tiempoCarrera;
	}
	
	public void setConductor(Conductor conductor){
		this.conductor = conductor;
	}
	
	public Conductor getConductor(){
		return this.conductor;
	}

	/**
	 * Lógica de la clase
	 */
	
	
	public void asignarConductor(PoolConductores conductores){
		setConductor(conductores.asignarConductor());
	}
	
	public void realizarPago(double pago){
		this.costeTotal = pago;
	}
	
	public double getCosteTotal(){
		return this.costeTotal;
	}

	public void setCosteTotal(double pago){
		this.costeTotal = pago;
	}
	
	public void recibirPropina(int propina){
		this.propina = propina;
	}
	
	public int getPropina(){
		return this.propina;
	}
	
	public void liberarConductor(){
		getConductor().setOcupado(false);
	}
}