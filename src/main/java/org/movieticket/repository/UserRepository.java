package org.movieticket.repository;

import org.movieticket.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(" select u from User u where u.emailAddress=:emailAddress and u.password=:password ")
    User userLogin(@Param("emailAddress") String e, @Param("password") String p);

}
