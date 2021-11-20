package fhi0.DIDR.repository;

import fhi0.DIDR.model.Ticket;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

//    @Query(value = "SELECT * FROM Ticket WHERE date >= :startDate AND date <= :endDate", nativeQuery = true)
//    List<Ticket> getAllBetweenDates(@Param("startDate") String startDate, @Param("endDate") String endDate);

}