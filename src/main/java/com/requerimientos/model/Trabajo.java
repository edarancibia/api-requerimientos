package com.requerimientos.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ot_trabajo")
public class Trabajo implements Serializable {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTrabajo;
	
	@Column(name="fecha")
	private java.util.Date fecha ;
	
	@Column(name="rut_solicita")
	private Long rut;
	
	@Column(name="sec_desde")
	private Long secDesde;
	
	@Column(name="anexo")
	private Long anexo;
	
	@Column(name="sec_para")
	private Long secPara;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="img")
	private String img;
	
	@Column(name="f_ini")
	private java.util.Date fIni;
	
	@Column(name="f_fin")
	private java.util.Date fFin;
	
	@Column(name="fk_estado")
	private Long fkEstado;
	
	
	
	public Trabajo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Trabajo(java.util.Date fecha, Long rut, Long secDesde, Long anexo, Long secPara, String titulo,
			String descripcion, String img, java.util.Date fIni, java.util.Date fFin, Long fkEstado) {
		super();
		this.fecha = fecha;
		this.rut = rut;
		this.secDesde = secDesde;
		this.anexo = anexo;
		this.secPara = secPara;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.img = img;
		this.fIni = fIni;
		this.fFin = fFin;
		this.fkEstado = fkEstado;
	}
	public Long getIdTrabajo() {
		return idTrabajo;
	}
	public void setIdTrabajo(Long idTrabajo) {
		this.idTrabajo = idTrabajo;
	}
	public java.util.Date getFecha() {
		return fecha;
	}
	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}
	public Long getRut() {
		return rut;
	}
	public void setRut(Long rut) {
		this.rut = rut;
	}
	public Long getSecDesde() {
		return secDesde;
	}
	public void setSecDesde(Long secDesde) {
		this.secDesde = secDesde;
	}
	public Long getAnexo() {
		return anexo;
	}
	public void setAnexo(Long anexo) {
		this.anexo = anexo;
	}
	public Long getSecPara() {
		return secPara;
	}
	public void setSecPara(Long secPara) {
		this.secPara = secPara;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public java.util.Date getfIni() {
		return fIni;
	}
	public void setfIni(java.util.Date fIni) {
		this.fIni = fIni;
	}
	public java.util.Date getfFin() {
		return fFin;
	}
	public void setfFin(java.util.Date fFin) {
		this.fFin = fFin;
	}
	public Long getFkEstado() {
		return fkEstado;
	}
	public void setFkEstado(Long fkEstado) {
		this.fkEstado = fkEstado;
	}
	
	
}
