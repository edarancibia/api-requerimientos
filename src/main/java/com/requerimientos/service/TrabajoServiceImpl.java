package com.requerimientos.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.requerimientos.dao.TrabajoDao;
import com.requerimientos.model.Trabajo;

@Service("trabajosService")
@Transactional
public class TrabajoServiceImpl implements TrabajoService{

	@Autowired
	private TrabajoDao _trabajoDao;
	
	@Override
	public void saveTrabajo(Trabajo trabajo) {
		// TODO Auto-generated method stub
		_trabajoDao.saveTrabajo(trabajo);
	}

	@Override
	public void DeleteTrabajoById(Long idTrabajo) {
		// TODO Auto-generated method stub
		_trabajoDao.DeleteTrabajoById(idTrabajo);
	}

	@Override
	public void updateTrabajo(Trabajo trabajo) {
		// TODO Auto-generated method stub
		_trabajoDao.updateTrabajo(trabajo);
	}

	@Override
	public List<Trabajo> findAllTrabajos() {
		// TODO Auto-generated method stub
		return _trabajoDao.findAllTrabajos();
	}

	@Override
	public List<Trabajo> findByEstado(Long estado) {
		// TODO Auto-generated method stub
		return _trabajoDao.findByEstado(estado);
	}

	@Override
	public Trabajo findById(Long idTrabajo) {
		// TODO Auto-generated method stub
		return _trabajoDao.findById(idTrabajo);
	}

}
