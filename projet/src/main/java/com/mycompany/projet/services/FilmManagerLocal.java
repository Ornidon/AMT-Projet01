package com.mycompany.projet.services;

import com.mycompany.projet.models.Actor;
import com.mycompany.projet.models.Film;
import java.util.List;
import javax.ejb.Local;

/**
 * Interface for the communication methods with the Datbase for the Films
 * 
 * @author Ioannis Noukakis & Thibaut Loiseau
 */
@Local
public interface FilmManagerLocal {
    
    Film getFilm(String title);
    Film getFilm(int id);
    List<Film> getFilms();
    List<Actor> getActors(String filmTitle);
    void create(String title, List<Actor> actors);
    void update(Film f, String newTitle);
    void delete(String title);
}
