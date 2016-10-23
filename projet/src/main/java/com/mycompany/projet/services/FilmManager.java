package com.mycompany.projet.services;

import com.mycompany.projet.models.Actor;
import com.mycompany.projet.models.Film;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ornidon
 */
@Stateless
public class FilmManager implements FilmManagerLocal{
    
    @EJB
    private MySQLCommon QueryExecutor;
    
    private final String GET_FILM_QUERY = "";
    private final String GET_FILMS_QUERY = "";
    private final String GET_ACTORS_QUERY = "";
    private final String CREATE_FILM_QUERY = "";
    private final String DELETE_FILM_QUERY = "";
    private final String UPDATE_FILM_QUERY = "";
    
    @Override
    public Film getFilm(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Film> getFilms() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Actor> getActors(String filmTitle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Film film, List<Actor> actors) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Film f, String newTitle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
