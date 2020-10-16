package com.stefanini.etlypfcc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="dim_tipo_ticket")
public class Dim_tipo_ticket implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tipo_ticket")
	private int id_tipo_ticket;
	@Column(name="tipo_ticket")
	private String tipo_ticket;
	@Column(name="codigo_ticket")
	private String codigo_ticket;
	
	public Dim_tipo_ticket() {
		
	}
	public int getId() {
		return this.id_tipo_ticket;
	}


}
