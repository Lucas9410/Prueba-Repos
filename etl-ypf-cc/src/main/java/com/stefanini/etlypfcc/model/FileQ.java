package com.stefanini.etlypfcc.model;

import javax.persistence.Entity;
import javax.persistence.Id;


public class FileQ {
	
	@Id
	private String numero;
	private int prioridad;
	private String deptoAsignado;
	private String SolicitadoPor;
	private String FechaApertura;
	
	
	public FileQ(String numero, int prioridad, String deptoAsignado, String solicitadoPor, String fechaApertura) {
		super();
		this.numero = numero;
		this.prioridad = prioridad;
		this.deptoAsignado = deptoAsignado;
		this.SolicitadoPor = solicitadoPor;
		this.FechaApertura = fechaApertura;
	}
	
	@Override
	public String toString() {
		return "FileQ [numero=" + numero + ", prioridad=" + prioridad + ", deptoAsignado=" + deptoAsignado
				+ ", SolicitadoPor=" + SolicitadoPor + ", FechaApertura=" + FechaApertura + "]";
	}

	public String getNumero() {
		return numero;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public String getDeptoAsignado() {
		return deptoAsignado;
	}


	public String getSolicitadoPor() {
		return SolicitadoPor;
	}


	public String getFechaApertura() {
		return FechaApertura;
	}
	public String getHoraApertura() {
		return FechaApertura.substring(11);
	}

	public FileQ() {
		// TODO Auto-generated constructor stub
	}
	

}
