package com.stefanini.etlypfcc.batch;

import java.util.List;
import com.stefanini.etlypfcc.repository.OpenTicketRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stefanini.etlypfcc.model.Fact_ticket_abierto;

@Component
public class DBWriter implements ItemWriter<Fact_ticket_abierto> {

	@Autowired
	private OpenTicketRepository openTicketRepository;
	@Override
	public void write(List<? extends Fact_ticket_abierto> tickets) throws Exception {
		System.out.println("Data saved:" + tickets);
		openTicketRepository.saveAll(tickets);
		
	}



}
