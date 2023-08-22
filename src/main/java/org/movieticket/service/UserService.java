package org.movieticket.service;

import org.movieticket.entity.Login;
import org.movieticket.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);

    Optional<User> getUser(int id);

    List<User> getAll();

    User loginFormed(Login login);
}
