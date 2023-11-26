package com.example.cinema.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="t1",types= {com.example.cinema.entities.Ticket.class})
public interface TicketProjection {

	public Long getId();
	public String getNomClient();
	public double getPrix();
	public Integer getCodePayment();
	public boolean getReservee();
	public Place getPlace();
}
