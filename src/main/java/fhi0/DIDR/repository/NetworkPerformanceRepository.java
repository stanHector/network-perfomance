package fhi0.DIDR.repository;

import fhi0.DIDR.model.NetworkPerformance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface NetworkPerformanceRepository extends JpaRepository<NetworkPerformance, Long> {

//    @Query("Select n from NetworkPerformance n where n.date between?1 and ?2")
//    Page<NetworkPerformance>  findByOrderByDateDesc(Timestamp start, Timestamp end, Pageable pageable);

    Page<NetworkPerformance>  findByOrderByDateDesc(Pageable pageable);
}
