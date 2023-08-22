package org.movieticket.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cinemaId;

    @Column
    private String cinemaName;

    @OneToMany(targetEntity = Screen.class, mappedBy = "cinema")
    private List<Screen> screens;

    public Cinema() {
    }

    public Cinema(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cinema{");
        sb.append("cinemaId=").append(cinemaId);
        sb.append(", cinemaName='").append(cinemaName).append('\'');
        sb.append(", screens=").append(screens);
        sb.append('}');
        return sb.toString();
    }

}
