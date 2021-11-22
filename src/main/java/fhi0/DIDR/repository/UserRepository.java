package fhi0.DIDR.repository;

import fhi0.DIDR.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);

    Users getByEmail(String email);

    @Query("from Users u where u.firstname =:keyword OR u.email=:keyword OR u.states=:keyword")
    Page<Users> findAll(Pageable pageable, @Param("keyword") String keyword);

}
