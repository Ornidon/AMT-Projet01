package com.mycompany.projet.services;

import com.mycompany.projet.models.Actor;
import com.mycompany.projet.models.Film;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ornidon
 */
@Stateless
public class FilmManager implements FilmManagerLocal {

    @EJB
    private MySQLCommon QueryExecutor;

    private final String GET_FILM_QUERY = "SELECT title, film_id FROM film WHERE title =?";
    private final String GET_FILM_QUERY2 = "SELECT title, film_id FROM film WHERE film_id =?";
    private final String GET_ACTOR_QUERY = "SELECT * FROM actor WHERE first_name =?,last_name = ? ";
    private final String GET_FILMS_QUERY = "SELECT title, film_id FROM film WHERE 1";
    private final String GET_ACTORS_QUERY = "SELECT * FROM actor\n"
            + "    INNER JOIN film_actor AS fa\n"
            + "        ON actor.actor_id = fa.actor_id\n"
            + "    INNER JOIN film AS f\n"
            + "        ON f.film_id = fa.film_id\n"
            + "    WHERE f.title = ?";
    private final String CREATE_FILM_QUERY = "INSERT INTO film(title) VALUES (?)";
    private final String ADD_ACTOR_TO_FILM = "INSERT INTO film_actor (actor_id, film_id) VALUES (? , ?)";
    private final String INSERT_ACTOR_IF_NOT_EXIST = "INSERT INTO actor (first_name, last_name) VALUES (? , ?)";
    private final String DELETE_FILM_QUERY = "DELETE FROM film WHERE title = ?";
    private final String UPDATE_FILM_QUERY = "UPDATE film SET title=? WHERE film_id = ?";

    @Override
    public Film getFilm(int id) {
        Film film = null;
        ResultSet rs = QueryExecutor.doQuery(GET_FILM_QUERY2, id);
        try {
            if (rs.next()) {
                film = new Film(rs.getString("title"), rs.getInt("film_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmManager.class.getName()).log(Level.SEVERE, null, ex);

        }
        return film;
    }
    
    @Override
    public Film getFilm(String title) {
        Film film = null;

        ResultSet rs = QueryExecutor.doQuery(GET_FILM_QUERY, title);
        try {
            if (rs.next()) {
                film = new Film(title, rs.getInt("film_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmManager.class.getName()).log(Level.SEVERE, null, ex);

        }
        return film;
    }

    @Override
    public List<Film> getFilms() {
        List<Film> films = new LinkedList<>();
        ResultSet rs = QueryExecutor.doQuery(GET_FILMS_QUERY);

        try {
            while (rs.next()) {

                films.add(new Film(rs.getString("title"), rs.getInt("film_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmManager.class.getName()).log(Level.SEVERE, null, ex);

        }
        return films;
    }

    @Override
    public List<Actor> getActors(String filmTitle) {
        List<Actor> actors = new LinkedList<>();
        ResultSet rs = QueryExecutor.doQuery(GET_ACTORS_QUERY, filmTitle);
        
        try {
            while (rs != null && rs.next()) {
                actors.add(new Actor(rs.getString("first_name"), rs.getString("last_name"),rs.getInt("actor_id")));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmManager.class.getName()).log(Level.SEVERE, null, ex);

        }
        return actors;
    }

    @Override
    public void create(String title, List<Actor> actors) {
        Film f = getFilm(title);
        if(f == null){
            try {
                QueryExecutor.doUpdateQuerry(CREATE_FILM_QUERY, title);
                f = getFilm(title);
                for(Actor a : actors){
                    ResultSet rs = QueryExecutor.doQuery(GET_ACTOR_QUERY, a.getFirst_name(), a.getLast_name());
                    if(rs == null || !rs.next()) {
                        QueryExecutor.doUpdateQuerry(INSERT_ACTOR_IF_NOT_EXIST);
                        ResultSet result = QueryExecutor.doQuery(GET_ACTOR_QUERY, a.getFirst_name(), a.getLast_name());
                        result.next();
                        QueryExecutor.doUpdateQuerry(ADD_ACTOR_TO_FILM, result.getInt("actor_id"), f.getFilm_id());
                    } else 
                        QueryExecutor.doUpdateQuerry(ADD_ACTOR_TO_FILM,rs.getInt("actor_id"), f.getFilm_id());
                }
            } catch (SQLException ex) {
                Logger.getLogger(FilmManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else System.out.println("Film already exist");
    }

    @Override
    public void update(Film f, String newTitle) {
        try {
            QueryExecutor.doUpdateQuerry(UPDATE_FILM_QUERY, newTitle, f.getFilm_id());
                    } catch (SQLException ex) {
            Logger.getLogger(FilmManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String title) {
        try {
            QueryExecutor.doUpdateQuerry(DELETE_FILM_QUERY, title);
        } catch (SQLException ex) {
            Logger.getLogger(FilmManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

}
