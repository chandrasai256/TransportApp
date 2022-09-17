package com.stackroute.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Directions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Directions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dirId;
	
	@Column(name = "origin")
	private String origin;
	
	@Column(name = "destination")
	private String destination;
	
	@Column(name = "distance")
	private int distance;
	
	@Column(name = "modeOfTransport")
	private String modeOfTransport;

	@Column(name = "time")
	private int time;
	
	@Column(name = "price")
	private int price;
	
}
