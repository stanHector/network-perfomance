package fhi0.DIDR.controller;

import fhi0.DIDR.dto.TicketDto;
import fhi0.DIDR.exception.ResourceNotFoundException;
import fhi0.DIDR.model.Ticket;
import fhi0.DIDR.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "https://network-performance.netlify.app")
@RestController
@RequestMapping("api/v1/")
public class TicketController {
    @Autowired
    TicketRepository ticketRepository;

    @GetMapping("tickets")
    public Page<Ticket> getTickets(Pageable pageable) {
        return ticketRepository.findByOrderByDateDesc(pageable);
    }

//    @GetMapping("tickets")
//    public Page<Ticket> getTickets(Pageable pageable) {
//        Calendar calendar = Calendar.getInstance();
//        String pattern = "yyyy-MM-dd";
//        DateFormat dateFormat = new SimpleDateFormat(pattern);
//        Date today = calendar.getTime();
//        String todayString = dateFormat.format(today);
//
//        calendar.add(Calendar.DAY_OF_MONTH, -7);
//        Date sevenDaysBefore = calendar.getTime();
//        String sevenDaysBeforeString = dateFormat.format(sevenDaysBefore);
//        return ticketRepository.findTicketCreatedAtBetween(pageable, todayString, sevenDaysBeforeString);
//    }

//    @GetMapping("all-tickets")
//    public Page<Ticket> getAllTickets(LocalDateTime start, LocalDateTime end, Pageable pageable) {
//        return ticketRepository.findByOrderByDateDesc(start, end, pageable);
//    }

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