package com.stefanini.etlypfcc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="fact_ticket_abierto")
public class Fact_ticket_abierto implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_ticket_abierto")
	private int id_ticket_abierto;
	@Column(name="numero_ticket")
	private String numero_ticket; 
	@Column(name="id_fecha_apertura")
	private int id_fecha_apertura; 
	@Column(name="hora_apertura")
	private String hora_apertura;
	@Column(name="id_criticidad") 
	private int id_criticidad;
	@Column(name="id_tipo_ticket") 
	private int id_tipo_ticket;
	@Column(name="id_analista_apertura") 
	private int id_analista_apertura;
	@Column(name="id_grupo_apertura") 
	private int id_grupo_apertura; 
	
	
	public Fact_ticket_abierto() {
		
	}
	@Override
	public String toString() {
	  return getClass().getSimpleName() + "\n[nro=" + numero_ticket + "\nid_fecha_apertura= " + id_fecha_apertura + "\nhora_apertura= "+ hora_apertura +
			 "\nid_criticidad= "+ id_criticidad + "\nid_tipo_ticket= " + id_tipo_ticket + "\nid_analista_apertura= "+ id_analista_apertura + "\nid_grupo_apertura= "+ id_grupo_apertura +"]";
	}

	public Fact_ticket_abierto(String numero_ticket, int id_fecha_apertura, String hora_apertura, int id_criticidad,int id_tipo_ticket,
		int id_analista_apertura, int id_grupo_apertura) {
		this.numero_ticket = numero_ticket;
		this.id_fecha_apertura = id_fecha_apertura;
		this.hora_apertura = hora_apertura;
		this.id_criticidad = id_criticidad;
		this.id_tipo_ticket = id_tipo_ticket;
		this.id_analista_apertura = id_analista_apertura;
		this.id_grupo_apertura = id_grupo_apertura;
	}
	public Fact_ticket_abierto(String numero_ticket, String hora_apertura, int id_criticidad,int id_tipo_ticket){
			this.numero_ticket = numero_ticket;
			this.hora_apertura = hora_apertura;
			this.id_criticidad = id_criticidad;
			this.id_tipo_ticket = id_tipo_ticket;
		}
	
	

}
