package com.stefanini.etlypfcc.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.stefanini.etlypfcc.model.Fact_ticket_abierto;
import com.stefanini.etlypfcc.model.FileQ;


@Component
public class Processor implements ItemProcessor<FileQ,Fact_ticket_abierto> {
	
	private static final Logger LOG = LoggerFactory.getLogger(Processor.class);

	@Override
	public Fact_ticket_abierto process(FileQ fileQ) throws Exception {
		final String numeroTicket = fileQ.getNumero();
		final String horaApertura = fileQ.getHoraApertura();
		final int cricitidad = fileQ.getPrioridad();
		final Fact_ticket_abierto ticket = new Fact_ticket_abierto(numeroTicket,horaApertura,cricitidad,1); 
		//TODO: (prueba)  Corregir parametros
		
		return ticket;
		
	}


}