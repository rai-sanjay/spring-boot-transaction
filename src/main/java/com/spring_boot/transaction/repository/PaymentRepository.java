package com.spring_boot.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_boot.transaction.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
