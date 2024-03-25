package com.spring_boot.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring_boot.transaction.entity.Payment;
import com.spring_boot.transaction.entity.Ticket;
import com.spring_boot.transaction.repository.PaymentRepository;
import com.spring_boot.transaction.repository.TicketRepository;

@Service
public class BookingService {

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private TicketService service;

	@Transactional
	public Ticket generateTicketWithTransaction(Payment payment) {
		paymentRepository.save(payment);
		Ticket ticket = new Ticket();
		ticket.setBoardingStation("Howrah");
		ticket.setDestinyStation("Chhapra");
		ticket.setPnr(657896598l);
		ticket.setTrainName("Sealdah Ballia Express");
		ticket.setTrainNumber(13031);
		
		/*Ticket Service has a Database call to persist ticket, but
		 * it will not persist, until this method executes completely.
		 * Because that is also part of same transaction
		 * */
		Ticket generatedTicket = service.generateTicket(ticket);
		System.out.println("Ticket generated - "+generatedTicket.getPnr());
		return generatedTicket;
	}
	/*Save Point - If any exception occurs in ticket
	 * service method, only that will be rolled back
	 * all logic before Save Point will be persisted
	*/
	
	
	
	
	
	/*
	 * Payment Details are saved in database
	 * Since unexpected error occurred, so Ticket is not generated
	 * This is not expected. It can be solved using @Transactional
	 * */
	public Ticket generateTicketWithoutTransaction(Payment payment) {
		int status = 1;
		paymentRepository.save(payment);
		if (status == 1) {
			throw new RuntimeException("wifi down...");
		}
		Ticket ticket = new Ticket();
		ticket.setBoardingStation("Howrah");
		ticket.setDestinyStation("Chhapra");
		ticket.setPnr(657896598l);
		ticket.setTrainName("Sealdah Ballia Express");
		ticket.setTrainNumber(13031);
		ticketRepository.save(ticket);
		return ticket;

	}

	
}
