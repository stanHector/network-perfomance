package fhi0.DIDR.repository;

import fhi0.DIDR.model.NetworkPerformance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetworkPerformanceRepository extends JpaRepository<NetworkPerformance, Long> {

}
