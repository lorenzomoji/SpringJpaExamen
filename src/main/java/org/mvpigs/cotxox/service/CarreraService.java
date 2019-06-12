package org.mvpigs.cotxox.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.mvpigs.cotxox.domain.Carrera;
import org.mvpigs.cotxox.repo.CarreraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarreraService {

	@Autowired
	private CarreraRepo carreraRepo;
	
	@Autowired
	private Carrera carrera;
	

	public Long crearCarrera(String tarjetaCredito, String origen, String destino, int distancia, int coste) {
		return carreraRepo.save(tarjetaCredito, origen, destino, distancia, coste);
	}
	
	public Carrera recuperaCarrera(Long idCarrera) {
		return carreraRepo.findById(idCarrera);
	}
	
	public void updateCarrera() {
		carreraRepo.delete(carrera);
		carreraRepo.save(carrera);
	}
	
}
