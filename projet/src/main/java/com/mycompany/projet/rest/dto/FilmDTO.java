/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projet.rest.dto;

import com.mycompany.projet.models.Actor;
import java.util.List;

/**
 *
 * @author Ornidon
 */
public class FilmDTO {
    private String title;
    private List<Actor> actors;

    public FilmDTO(String title, List<Actor> actors) {
        this.title = title;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
}
