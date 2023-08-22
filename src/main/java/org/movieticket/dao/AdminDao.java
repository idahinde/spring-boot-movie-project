package org.movieticket.dao;

import org.movieticket.entity.Admin;
import org.movieticket.entity.Login;
import org.movieticket.repository.AdminRepository;
import org.movieticket.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AdminDao implements AdminService {

    private AdminRepository repository;

    public AdminDao(AdminRepository repository) {
        this.repository = repository;
    }

    @Override
    public Admin save(Admin admin) {
        return repository.save(admin);
    }

    @Override
    public Optional<Admin> getAdminById(int id) {
        return repository.findById(id);
    }

    @Override
    public Admin loginFormed(Login login) {
        return repository.adminLogin(login.getEmailAddress(), login.getPassword());
    }

}
