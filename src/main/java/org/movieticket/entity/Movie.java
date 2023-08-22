package org.movieticket.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    @Column
    private String title;

    @Column(columnDefinition = " date not null ")
    private Date releaseDate;

    @Column
    private Integer showCycle;

    @JoinColumn(name = "screenId", referencedColumnName = "screenId")
    @OneToOne(targetEntity = Screen.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Screen screen;

    @Column(columnDefinition = " longtext not null ")
    private String imageData;

    public Movie() {
    }

    public Movie(String title, Date releaseDate, Integer showCycle, Screen screen, String imageData) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.showCycle = showCycle;
        this.screen = screen;
        this.imageData = imageData;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getShowCycle() {
        return showCycle;
    }

    public void setShowCycle(Integer showCycle) {
        this.showCycle = showCycle;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Movie{");
        sb.append("movieId=").append(movieId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", releaseDate=").append(releaseDate);
        sb.append(", showCycle=").append(showCycle);
        sb.append(", screen=").append(screen);
        sb.append(", imageData='").append(imageData).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
