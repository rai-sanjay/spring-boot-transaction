package com.spring_boot.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring_boot.transaction.entity.Ticket;
import com.spring_boot.transaction.repository.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository repository;
	
	/*Default transaction propagation is REQUIRED
	 * Which means Spring will not create a seprate transaction
	 * The method will be part of calling method transaction
	 * Ticket will be saved, once calling method executes without exception
	 * */
	@Transactional(propagation = Propagation.MANDATORY)
	public Ticket generateTicket(Ticket ticket) {
		return repository.save(ticket);
		
	}

}
