package com.example.cinema.entities;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="p1",types= {com.example.cinema.entities.Projection.class})
public interface ProjectionProj {
	public Long getId();
	public double getPrix();
	public Date getdateprojection();
	public  Salle getSalle();
	public Film getFilm();
	public Seance getSeance();
	public Collection<Ticket> getTickets = null;
}
