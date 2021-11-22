package fhi0.DIDR.repository;

import fhi0.DIDR.model.InternetDowntime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternetDowntimeRepository extends JpaRepository<InternetDowntime, Long> {
    Page<InternetDowntime> findByOrderByDateDesc(Pageable pageable);
}