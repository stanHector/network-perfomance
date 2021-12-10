package fhi0.DIDR.repository;

import fhi0.DIDR.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

//    Page<Ticket> findByOrderByDateDesc(LocalDateTime start, LocalDateTime end, Pageable pageable);
    Page<Ticket> findByOrderByDateDesc(Pageable pageable);

//    @Query("Select t from Ticket t where t.date between?1 and ?2")
//    Page<Ticket>  findByOrderByDateDesc(LocalDateTime start, LocalDateTime end, Pageable pageable);

//    @Query("SELECT t FROM Ticket WHERE date Like %?1%")
//    Page<Ticket> findTicketByMonthAndDay(@Param("date") String date, Pageable pageable);

//    Page<Ticket> findTicketCreatedAtBetween(Pageable pageable, String todayString, String sevenDaysBeforeString);
}