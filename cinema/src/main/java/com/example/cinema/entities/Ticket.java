package com.example.cinema.entities;

import java.io.Serializable;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Ticket {

	@Id
	@GeneratedValue
	private Long id;
	private String nomClient;
	private double prix;
	@Column(unique = false,nullable = true)
	private Integer codePayment;//int la valeur par defaut=0 ms Integer est un objet la valeur par defaut=null
	private Boolean reservee;
	@ManyToOne
	private Place place;
	@ManyToOne
	private Projection projection;
}
