package fhi0.DIDR.repository;

import fhi0.DIDR.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Abbas Irekeola
 * @Email abbasirekeola@gmail.com
 * 26/05/2021-21:26
 */

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
