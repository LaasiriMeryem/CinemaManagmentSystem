package com.example.cinema.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cinema.dao.FilmRepository;
import com.example.cinema.dao.TicketRepository;
import com.example.cinema.entities.Film;
import com.example.cinema.entities.Ticket;

import jakarta.transaction.Transactional;
import lombok.Data;

@CrossOrigin("*")
@RestController
public class CinemaRestController {
 
	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	FilmRepository filmRepository;
	
@GetMapping(path="/imageFilm/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
public byte[] image(@PathVariable (name="id")Long id) throws Exception {
	Film f=filmRepository.findById(id).get();
	String photoName=f.getPhoto();
	File file = new File(System.getProperty("user.home") + "/cinema/images/" + photoName+".jpg");
	Path path=Paths.get(file.toURI());
		return Files.readAllBytes(path);	
}

@PostMapping("/payer")
@Transactional

public List<Ticket> payerTickets(@RequestBody TicketForm ticketForm){
	 System.out.println(ticketForm);
	List<Ticket> listTickets=new ArrayList<>();
	ticketForm.getTickets().forEach(id->{
		Ticket ticket=ticketRepository.findById(id).get();
		ticket.setNomClient(ticketForm.getNomClient());
		ticket.setReservee(true);
		ticket.setCodePayment(ticketForm.getCodePayment());
		ticketRepository.save(ticket);
		listTickets.add(ticket);
	});
	return listTickets;
}

}


@Data
class TicketForm{
	private String nomClient;
	private int codePayment;
	private List<Long> tickets=new ArrayList<>();
	
}
