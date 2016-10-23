package com.mycompany.projet.models;

import java.util.List;

/**
 *
 * @author Ornidon
 */
public class Film {
    private String title;
    private List<Actor> actors;
    private int film_id;

    public Film(String title, List<Actor> actors, int film_id) {
        this.title = title;
        this.actors = actors;
        this.film_id = film_id;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public int getFilm_id() {
        return film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
    
}
