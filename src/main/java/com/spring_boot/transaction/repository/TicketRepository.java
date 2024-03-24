package com.spring_boot.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_boot.transaction.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
