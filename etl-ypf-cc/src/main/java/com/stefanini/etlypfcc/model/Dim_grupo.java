package com.stefanini.etlypfcc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="dim_grupo")
public class Dim_grupo implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_grupo")
	private int id_grupo;
	@Column(name="id_torre_servicio") 
	private int id_torre_servicio; //objeto de clase torre_servicio
	@Column(name="id_zona") 
	private int id_zona; //objeto de clase zona
	@Column(name="grupo")
	private String grupo;
	@Column(name="descripcion")
	private String descripcion;
	
	public Dim_grupo() {
		
	}
	public Dim_grupo(int id_torre,int id_zona,String grupo,String descripcion) {
		this.id_torre_servicio = id_torre;
		this.id_zona = id_zona;
		this.grupo = grupo;
		this.descripcion = descripcion;
	}
	public int getId() {
		return this.id_grupo;
	}
	public String getGrupo() {
		return this.grupo;
	}
	

}
