package fhi0.DIDR.repository;

import fhi0.DIDR.model.InternetDowntime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InternetDowntimeRepository extends JpaRepository<InternetDowntime, Long> {
    Page<InternetDowntime> findByOrderByDateDesc(Pageable pageable);

}