package com.spring_boot.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot.transaction.entity.Payment;
import com.spring_boot.transaction.entity.Ticket;
import com.spring_boot.transaction.service.BookingService;

@RestController
@RequestMapping("/irctc/")
public class BookingController {

	@Autowired
	private BookingService service;

	@PostMapping("bookTicket")
	public ResponseEntity<Ticket> bookTicket(@RequestBody Payment payment) {
		Ticket ticket = service.generateTicketWithoutTransaction(payment);

		return new ResponseEntity<>(ticket, HttpStatus.OK);

	}

}
