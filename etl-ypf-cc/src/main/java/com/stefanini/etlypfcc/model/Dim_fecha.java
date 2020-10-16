package com.stefanini.etlypfcc.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="dim_fecha")
public class Dim_fecha implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_fecha")
	private int id_fecha;
	@Column(name="dia") 
	private Date dia; 
	@Column(name="mes") 
	private int mes; 
	@Column(name="ano") 
	private int ano; 
	@Column(name="trimestre") 
	private int trimestre; 
	@Column(name="feriado") 
	private int feriado; 
	@Column(name="id_periodo_facturacion") 
	private int id_periodo_facturacion; 
	@Column(name="dia_semana")
	private String dia_semana;
	
	public Dim_fecha() {
		
	}
	
	public int getId() {
		return this.id_fecha;
	}
	public Date getDia() {
		return this.dia;
	}
	
	

}
