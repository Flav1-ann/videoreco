package fr.ensup.video.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("serie")
public class Series extends Video{
    private Integer nbEpisodes;
    private Integer nbSeasons;

    public Series(String title, String type, Integer nbEpisodes, Integer nbSeasons) {
        super(title, type);
        this.nbEpisodes = nbEpisodes;
        this.nbSeasons = nbSeasons;
    }

    public Series(long id, String title, String type, Integer nbEpisodes, Integer nbSeasons) {
        super(id, title, type);
        this.nbEpisodes = nbEpisodes;
        this.nbSeasons = nbSeasons;
    }

    public Series(String title, String type, User user, Integer nbEpisodes, Integer nbSeasons) {
        super(title, type, user);
        this.nbEpisodes = nbEpisodes;
        this.nbSeasons = nbSeasons;
    }

    public Series(Integer nbEpisodes, Integer nbSeasons) {
        this.nbEpisodes = nbEpisodes;
        this.nbSeasons = nbSeasons;
    }

    public Series() {

    }

    public Integer getNbEpisodes() {
        return nbEpisodes;
    }

    public void setNbEpisodes(Integer nbEpisodes) {
        this.nbEpisodes = nbEpisodes;
    }

    public Integer getNbSeasons() {
        return nbSeasons;
    }

    public void setNbSeasons(Integer nbSeasons) {
        this.nbSeasons = nbSeasons;
    }
}
