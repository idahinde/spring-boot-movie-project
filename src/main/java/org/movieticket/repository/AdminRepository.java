package org.movieticket.repository;

import org.movieticket.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    @Query(" select a from Admin a where a.emailAddress=:emailAddress and a.password=:password ")
    Admin adminLogin(@Param("emailAddress") String e, @Param("password") String p);
}
