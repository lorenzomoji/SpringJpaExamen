package org.mvpigs.cotxox.repo;

import java.util.Optional;

import org.mvpigs.cotxox.domain.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarreraRepo extends JpaRepository<Carrera, Long>{
	
	Carrera findById(Long id);

	Long save(String tarjetaCredito, String origen, String destino, int distancia, int coste);

	String findById(int id);

}
