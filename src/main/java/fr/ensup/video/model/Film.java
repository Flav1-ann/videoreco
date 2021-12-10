package fr.ensup.video.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("film")
public class Film extends Video{

    private Long duration;
    private Timestamp releaseDate;


    public Film(String title, String type, Long duration, Timestamp releaseDate) {
        super(title, type);
        this.duration = duration;
        this.releaseDate = releaseDate;
    }

    public Film(long id, String title, String type, Long duration, Timestamp releaseDate) {
        super(id, title, type);
        this.duration = duration;
        this.releaseDate = releaseDate;
    }

    public Film(String title, String type, User user, Long duration, Timestamp releaseDate) {
        super(title, type, user);
        this.duration = duration;
        this.releaseDate = releaseDate;
    }

    public Film(Long duration, Timestamp releaseDate) {
        this.duration = duration;
        this.releaseDate = releaseDate;
    }

    public Film() {

    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Timestamp getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Timestamp releaseDate) {
        this.releaseDate = releaseDate;
    }
}
