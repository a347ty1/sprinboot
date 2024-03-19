package com.tsi.peter.demo;

import jakarta.persistence.*;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name="film")
public class Film {

    // Definitions

    @Id
    @Column(name = "film_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short filmID;

    @Column(name = "title")
    private String title;

    @Column(name = "release_year")
    private int year;

    @Column(name = "length")
    private int length;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn( name= "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name="actor_id", referencedColumnName = "actor_id")
    ) /* Tells the app to take load the films from actor ids when called. (1 way relationship)*/
    private Set<Actor> actors;


    // Getters
    public short getFilmID() {
        return filmID;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    // Setters

    public void setFilmID(short filmID) {
        this.filmID = filmID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setLength(int length) {
        this.length = length;
    }

    /*
    public void setRental_rate(Double rental_rate) {
        this.rental_rate = rental_rate;
    }

    public void setRental_duration(Integer rental_duration) {
        this.rental_duration = rental_duration;
    }
     */
}
