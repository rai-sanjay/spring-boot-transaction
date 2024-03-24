package com.spring_boot.transaction.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table
@Data
@NoArgsConstructor
public class Ticket {
	@Id
	@GeneratedValue
	private Long pnr;
	private String boardingStation;
	private String destinyStation;
	private Integer trainNumber;
	private String trainName;
}
