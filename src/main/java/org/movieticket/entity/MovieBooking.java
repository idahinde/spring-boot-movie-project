package org.movieticket.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class MovieBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "movieId", referencedColumnName = "movieId")
    @ManyToOne(targetEntity = Movie.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Movie movie;

    @Column(columnDefinition = " date not null ")
    private Date bookingDate;

    @Column(columnDefinition = " time not null ")
    private Time bookingTime;

    public MovieBooking() {
    }

    public MovieBooking(User user, Movie movie, Date bookingDate, Time bookingTime) {
        this.user = user;
        this.movie = movie;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Time getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Time bookingTime) {
        this.bookingTime = bookingTime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MovieBooking{");
        sb.append("bookingId=").append(bookingId);
        sb.append(", user=").append(user);
        sb.append(", movie=").append(movie);
        sb.append(", bookingDate=").append(bookingDate);
        sb.append(", bookingTime=").append(bookingTime);
        sb.append('}');
        return sb.toString();
    }

}
