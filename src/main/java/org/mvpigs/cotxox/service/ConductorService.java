package org.mvpigs.cotxox.service;

import org.mvpigs.cotxox.domain.Carrera;
import org.mvpigs.cotxox.domain.Conductor;
import org.mvpigs.cotxox.repo.ConductorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConductorService {

	@Autowired
	private ConductorRepo conductorRepo;
	
	@Autowired
	private Conductor conductor;
	

	public Long crearCarrera(String tarjetaCredito, String origen, String destino, int distancia, int coste) {
		return conductorRepo.save(tarjetaCredito, origen, destino, distancia, coste);
	}
	
	public Conductor recuperarConductor(String tarjetaCredito) {
		return conductorRepo.findByTarjeta(tarjetaCredito);
	}
}
