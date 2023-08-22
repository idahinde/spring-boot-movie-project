package org.movieticket.dao;

import org.movieticket.entity.Login;
import org.movieticket.entity.User;
import org.movieticket.repository.UserRepository;
import org.movieticket.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserDao implements UserService {

    private UserRepository repository;

    public UserDao(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public Optional<User> getUser(int id) {
        return repository.findById(id);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User loginFormed(Login login) {
        return repository.userLogin(login.getEmailAddress(), login.getPassword());
    }

}
