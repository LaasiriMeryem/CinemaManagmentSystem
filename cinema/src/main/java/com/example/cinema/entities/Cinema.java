package com.example.cinema.entities;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Cinema implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private double longitude;
	private double latitude;
	private double altitude;
	private int nombreSalles;
	@OneToMany( targetEntity=Salle.class, mappedBy="cinema" )
	private Collection<Salle> salles;
	@ManyToOne
	private Ville ville;
	


	
	
	
}
