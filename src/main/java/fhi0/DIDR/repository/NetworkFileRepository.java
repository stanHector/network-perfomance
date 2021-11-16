package fhi0.DIDR.repository;

import fhi0.DIDR.model.NetworkFiles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetworkFileRepository extends CrudRepository<NetworkFiles, Long> {
}
