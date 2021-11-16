package fhi0.DIDR.repository;

import fhi0.DIDR.model.InternetDowntime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InternetDowntimeRepository extends JpaRepository<InternetDowntime, Long> {
//    InternetDowntimeDto findByAssetTag(String assetTag);
//
//    InternetDowntimeDto findBySerialnumber(String serialnumber);
}