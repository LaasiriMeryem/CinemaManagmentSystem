package com.example.cinema.entities;

import java.io.Serializable;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
public class Salle implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private int nombrePlaces;
	@ManyToOne 
	@JsonProperty(access =Access.WRITE_ONLY)
	private Cinema cinema;
	@OneToMany( targetEntity=Place.class, mappedBy="salle" )
	@JsonProperty(access =Access.WRITE_ONLY)
	private Collection<Place> places;
	@OneToMany( targetEntity=Projection.class, mappedBy="salle" )
	@JsonProperty(access =Access.WRITE_ONLY)
	private Collection<Projection> projections;
	
	
	
	
}
