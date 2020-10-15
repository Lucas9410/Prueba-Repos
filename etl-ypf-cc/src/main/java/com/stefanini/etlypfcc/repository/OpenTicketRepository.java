package com.stefanini.etlypfcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stefanini.etlypfcc.model.Fact_ticket_abierto;


public interface OpenTicketRepository extends JpaRepository<Fact_ticket_abierto,Integer> {

}
