package fr.ensup.video.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@DiscriminatorValue("film")
public class Film extends Video{

    private Timestamp duration;
    private Timestamp release;

    public Film() {
        super();
    }

    public Film(String title, String type, Timestamp duration, Timestamp release) {
        super(title, type);
        this.duration = duration;
        this.release = release;
    }

    public Film(long id, String title, String type, Timestamp duration, Timestamp release) {
        super(id, title, type);
        this.duration = duration;
        this.release = release;
    }

    public Film(String title, String type, User user, Timestamp duration, Timestamp release) {
        super(title, type, user);
        this.duration = duration;
        this.release = release;
    }

    public Film(Timestamp duration, Timestamp release) {
        this.duration = duration;
        this.release = release;
    }

    public Timestamp getDuration() {
        return duration;
    }

    public void setDuration(Timestamp duration) {
        this.duration = duration;
    }

    public Timestamp getRelease() {
        return release;
    }

    public void setRelease(Timestamp release) {
        this.release = release;
    }
}
