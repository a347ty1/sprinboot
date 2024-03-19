package com.tsi.peter.demo;

import jakarta.persistence.*;

@Entity
@Table(name="film_actor")
public class FilmActor {
    @Id
    @Column(name="film_id", unique = false)
    private int film_id;

    @Column(name="actor_id")
    private int actor_id;


    public int getActor_id() {
        return actor_id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }
}
