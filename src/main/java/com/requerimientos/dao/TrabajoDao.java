package com.requerimientos.dao;

import java.util.List;

import com.requerimientos.model.Trabajo;

public interface TrabajoDao {

	void saveTrabajo(Trabajo trabajo);
	
	void DeleteTrabajoById(Long idTrabajo);
	
	void updateTrabajo(Trabajo trabajo);
	
	List<Trabajo> findAllTrabajos();
	
	List<Trabajo> findByEstado(Long estado);
	
	Trabajo findById(Long idTrabajo);
}
