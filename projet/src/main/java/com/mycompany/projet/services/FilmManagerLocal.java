/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projet.services;

import com.mycompany.projet.models.Actor;
import com.mycompany.projet.models.Film;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ornidon
 */
@Local
public interface FilmManagerLocal {
    
    Film getFilm(String title);
    List<Film> getFilms();
    List<Actor> getActors(String filmTitle);
    void create(Film film, List<Actor> actors);
    void update(Film f, String newTitle);
    void delete(String title);
}