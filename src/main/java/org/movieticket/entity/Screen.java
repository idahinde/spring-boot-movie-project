package org.movieticket.entity;

import javax.persistence.*;

@Entity
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer screenId;

    @Column
    private String type;

    @JoinColumn(name = "cinemaId", referencedColumnName = "cinemaId")
    @ManyToOne(targetEntity = Cinema.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Cinema cinema;

    public Screen() {
    }

    public Screen(String type, Cinema cinema) {
        this.type = type;
        this.cinema = cinema;
    }

    public Integer getScreenId() {
        return screenId;
    }

    public void setScreenId(Integer screenId) {
        this.screenId = screenId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Screen{");
        sb.append("screenId=").append(screenId);
        sb.append(", type='").append(type).append('\'');
        sb.append(", cinema=").append(cinema);
        sb.append('}');
        return sb.toString();
    }

}
