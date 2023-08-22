package org.movieticket.service;

import org.movieticket.entity.Admin;
import org.movieticket.entity.Login;

import java.util.Optional;

public interface AdminService {

    Admin save(Admin admin);

    Optional<Admin> getAdminById(int id);

    Admin loginFormed(Login login);

}
