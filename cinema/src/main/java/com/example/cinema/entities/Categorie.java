package com.example.cinema.entities;

import java.io.Serializable;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
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
public class Categorie implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	@Column(length = 75)
	private String name;
	@OneToMany( targetEntity=Film.class, mappedBy="categorie" )
	@JsonProperty(access =Access.WRITE_ONLY)
	private Collection<Film> films;
}
