package fr.ensup.video.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@DiscriminatorValue("film")
public class Film extends Video{

    private Long duration;
    private Timestamp release;


    public Film(String title, String type, Long duration, Long release) {

    }

    public Film(String title, String type, Long duration, Timestamp release) {
        super(title, type);
        this.duration = duration;
        this.release = release;
    }

    public Film(long id, String title, String type, Long duration, Timestamp release) {
        super(id, title, type);
        this.duration = duration;
        this.release = release;
    }

    public Film(String title, String type, User user, Long duration, Timestamp release) {
        super(title, type, user);
        this.duration = duration;
        this.release = release;
    }

    public Film(Long duration, Timestamp release) {
        this.duration = duration;
        this.release = release;
    }


    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Timestamp getRelease() {
        return release;
    }

    public void setRelease(Timestamp release) {
        this.release = release;
    }
}
