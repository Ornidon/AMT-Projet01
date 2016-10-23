package com.mycompany.projet.models;

import java.util.List;

/**
 *
 * @author Ornidon
 */
public class Film {
    private String title;
    private int film_id;

    public Film(String title, int film_id) {
        this.title = title;
        this.film_id = film_id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
       
}
