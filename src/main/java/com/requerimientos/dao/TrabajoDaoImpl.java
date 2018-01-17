package com.requerimientos.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.requerimientos.model.Trabajo;

@Repository
@Transactional
public class TrabajoDaoImpl extends AbstractSession implements TrabajoDao {

	@Override
	public void saveTrabajo(Trabajo trabajo) {
		// TODO Auto-generated method stub
		getSession().persist(trabajo);
	}

	@Override
	public void DeleteTrabajoById(Long idTrabajo) {
		// TODO Auto-generated method stub
		Trabajo trabajo = findById(idTrabajo);
		if (trabajo != null) {
			getSession().delete(idTrabajo);
		}	
	}

	@Override
	public void updateTrabajo(Trabajo trabajo) {
		// TODO Auto-generated method stub
		getSession().update(trabajo);
	}

	@Override
	public List<Trabajo> findAllTrabajos() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Trabajo").list();
	}

	@Override
	public List<Trabajo> findByEstado(Long estado) {
		// TODO Auto-generated method stub
		return (List<Trabajo>) getSession().createQuery(
				"from Trabajo where fkEstado = :estado")
				.setParameter("estado", estado).list();
	}

	@Override
	public Trabajo findById(Long idTrabajo) {
		// TODO Auto-generated method stub
		return (Trabajo) getSession().get(Trabajo.class, idTrabajo);
	}

}
