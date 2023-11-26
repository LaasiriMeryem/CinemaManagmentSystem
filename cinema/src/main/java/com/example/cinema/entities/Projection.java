package com.example.cinema.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

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
public class Projection implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	private Date dateprojection;
	private double prix;
	@ManyToOne
	private Film film;
	@ManyToOne
	@JsonProperty(access =Access.WRITE_ONLY)
	private Salle salle;
	@OneToMany( targetEntity=Ticket.class, mappedBy="projection" )
	@JsonProperty(access =Access.WRITE_ONLY)
	private Collection<Ticket> tickets;
	@ManyToOne
	private Seance seance;
	
	
	
}
