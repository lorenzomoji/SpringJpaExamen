package org.mvpigs.cotxox.repo;

import java.util.List;

import org.mvpigs.cotxox.domain.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConductorRepo extends JpaRepository<Conductor, Long>{

	Conductor findByTarjeta(String tarjeta);
	
	@Query("from Conductor conductor where conductor.co_ocupado =: false")
	public List<Conductor> findByOcupado(int id);
	
}
