package com.tsi.peter.demo;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name="actor")
@CrossOrigin
public class Actor {

    // Definitions - Values referenced in later methods

    @Id
    @Column(name="actor_id", unique=true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int actor_id;

    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    public int getActor_id() {
        return actor_id;
    }


    @ManyToMany(mappedBy = "actors") /* Brings the film list mapped in Film.java */
    private Set<Film> films = new HashSet<>();

    //// Methods

    // Getters - Get current values

    public Set<Film> getFilms() {
        return films;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    // Setters - Set new values (unused)

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public void setFirst_name(String firstName) {
        this.first_name = firstName;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


}
