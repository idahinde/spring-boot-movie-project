package org.movieticket.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String phoneNumber;
    @Column
    private String emailAddress;
    @Column
    private String password;
    @Column(columnDefinition = " ENUM('Y','N') NOT NULL DEFAULT 'N' ")
    private String active = "Y";
    @OneToMany(targetEntity = MovieBooking.class, cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<MovieBooking> movieBookings;

    public User() {
    }

    public User(String firstName, String lastName, String phoneNumber, String emailAddress, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public List<MovieBooking> getMovieBookings() {
        return movieBookings;
    }

    public void setMovieBookings(List<MovieBooking> movieBookings) {
        this.movieBookings = movieBookings;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("userId=").append(userId);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", emailAddress='").append(emailAddress).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", active='").append(active).append('\'');
        sb.append(", movieBookings=").append(movieBookings);
        sb.append('}');
        return sb.toString();
    }

}
