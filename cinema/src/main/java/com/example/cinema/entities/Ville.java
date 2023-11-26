package com.example.cinema.entities;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Ville implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private double longitude;
	private double latitude;
	private double altitude;
	@OneToMany( targetEntity=Cinema.class, mappedBy="ville" )
	private Collection<Cinema> cinemas;
}
