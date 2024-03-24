package com.spring_boot.transaction.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table
public class Payment {

	@Id
	@GeneratedValue
	private Long id;
	private Integer amount;
	private String paymentType;
	private String status;

}
