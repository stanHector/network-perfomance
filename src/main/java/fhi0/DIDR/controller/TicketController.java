package fhi0.DIDR.controller;

import fhi0.DIDR.dto.TicketDto;
import fhi0.DIDR.exception.ResourceNotFoundException;
import fhi0.DIDR.model.Ticket;
import fhi0.DIDR.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/")
public class TicketController {
    @Autowired
    TicketRepository ticketRepository;

    @GetMapping("tickets")
    List<Ticket> getTickets() {
        return ticketRepository.findAll(Sort.by("date").ascending());
    }

    @PostMapping("tickets")
    ResponseEntity<Object> createTicket(@Valid @RequestBody Ticket ticket) {
        return new ResponseEntity<>(ticketRepository.save(ticket), HttpStatus.CREATED);
    }

    //get ticket by Id
    @GetMapping("ticket/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found for this id :: " + id));
        return ResponseEntity.ok().body(ticket);
    }

    @PutMapping("ticket/{id}")
    public Ticket updateTicket(@PathVariable("id") Long id, @Valid @RequestBody TicketDto ticketDto) throws ResourceNotFoundException {
        System.out.println("Update Ticket with ID = " + id + "...");
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found for this id :: " + id));

        ticket.setNumberOfServiceDeskTicketsRecieved(ticketDto.getNumberOfServiceDeskTicketsRecieved());
        ticket.setNumberOfServiceDeskTicketsResolved(ticketDto.getNumberOfServiceDeskTicketsResolved());
        ticket.setNumberOfUsersOnTheNetwork(ticketDto.getNumberOfUsersOnTheNetwork());

        final Ticket updatedTicket = ticketRepository.save(ticket);
        System.out.println("Updated User " + updatedTicket);
        return ticketRepository.save(updatedTicket);
    }

    @DeleteMapping("ticket/{id}")
    public Map<String, Boolean> deleteTicket(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found for this id :: " + id));
        ticketRepository.delete(ticket);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted!", Boolean.TRUE);
        return response;
    }
}