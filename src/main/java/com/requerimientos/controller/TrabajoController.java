package com.requerimientos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.requerimientos.util.CustomErrorType;
import com.requerimientos.model.Trabajo;
import com.requerimientos.service.TrabajoService;

@Controller
@RequestMapping("/v1")
public class TrabajoController {

	@Autowired
	TrabajoService _trabajoService;
	
	//GET
	@RequestMapping(value="/trabajos", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Trabajo>> getTrabajos(@RequestParam(value="estado", required=false) Long estado){
		
		List<Trabajo> trabajos = new ArrayList<>();
		
		if (estado != null) {
			trabajos = _trabajoService.findByEstado(estado);
			if (trabajos.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
 		}
		
		if (estado == null) {
			trabajos = _trabajoService.findAllTrabajos();
			if (trabajos.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
		}
		
		return new ResponseEntity<List<Trabajo>>(trabajos, HttpStatus.OK);
	}
	
	//POST
	@RequestMapping(value="/trabajos", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createTrabajo(@RequestBody Trabajo trabajo,UriComponentsBuilder uriComponentsBuilder){
		if (trabajo.getTitulo().isEmpty() || trabajo.getTitulo().equals(null)) {
			return new ResponseEntity(new CustomErrorType("nameCourse is required"), HttpStatus.CONFLICT);
		}
		
		_trabajoService.saveTrabajo(trabajo);
		Trabajo trabajo2 = _trabajoService.findById(trabajo.getIdTrabajo());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(
				uriComponentsBuilder.path("/v1/socialMedias/{id}")
				.buildAndExpand(trabajo2.getIdTrabajo())
				.toUri()
				);
			
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		
	}
	
	
	//UPDATE
	@RequestMapping(value="/trabajos/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<?> updateTrabajo(@PathVariable("id") Long idTrabajo, @RequestBody Trabajo trabajo ){
		Trabajo currentTrabajo = _trabajoService.findById(idTrabajo);
		if (currentTrabajo == null) {
			return new ResponseEntity(new CustomErrorType("idCourse is required"), HttpStatus.CONFLICT);
		}
		
		currentTrabajo.setFkEstado(trabajo.getFkEstado());
		currentTrabajo.setfFin(trabajo.getFecha());
		
		_trabajoService.updateTrabajo(currentTrabajo);
		return new ResponseEntity<Trabajo>(currentTrabajo, HttpStatus.OK);	
	}
	
	
	
	
	
}
