package fhi0.DIDR.repository;

import fhi0.DIDR.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Page<Ticket> findByOrderByDateDesc(Pageable pageable);
}