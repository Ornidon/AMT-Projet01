/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projet.rest;

import com.mycompany.projet.models.Actor;
import com.mycompany.projet.models.Film;
import com.mycompany.projet.rest.dto.FilmDTO;
import com.mycompany.projet.services.FilmManagerLocal;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Ornidon
 */
@Stateless
@Path("/films")
public class FilmRessource {
    @EJB
    FilmManagerLocal manager;
    
    @Context
    UriInfo uriInfo;

    /**
     * Get all actor in the film using his title.
     *
     * @param title The film title
     * @return The film with a status.
     */
    @GET
    @Path("/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActors(@PathParam(value="title") String title){
        List<Actor> actors;
        actors = manager.getActors(title);
        if (actors == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
        return Response
                .ok(new FilmDTO(title,actors))
                .build();
    }

    /**
     * Get all films and all actors
     *
     * @return all film and actors plus a status.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilms(){
        List<FilmDTO> result = new LinkedList<>();
        List<Film> films = manager.getFilms();
        for(Film f: films){
            result.add(new FilmDTO(f.getTitle(), manager.getActors(f.getTitle())));
        }
        return Response
                .ok(result)
                .build();
    }

    /**
     * Create a new film from the json.
     *
     * @param film The film that we want to save on the server
     * @return A status about the creation.
     * 
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(FilmDTO film) {
        String filmTitle = film.getTitle();
        List<Actor> actors = film.getActors();

        if (filmTitle == null && filmTitle == "") {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .build();
        }

        manager.create(filmTitle, actors);
        
        URI href = uriInfo
                .getBaseUriBuilder()
                .path(FilmRessource.class)
                .path(FilmRessource.class, "getFilms")
                .build(filmTitle);

        return Response.created(href).build();
    }

    /**
     * Delete a film which has title as title.
     * 
     * @param title Username to delete
     * @return A status about the deletion.
     */
    @DELETE
    @Path("/{title}")
    public Response remove(@PathParam(value = "title") String title) {
        
        if(manager.getFilm(title) == null)
            return Response
                    .status(404)
                    .build(); 
        else 
            manager.delete(title);
        return Response
                .ok()
                .build(); 

    }


    /**
     * Modify a film and change his title.
     * 
     * @param film the film that we want to update
     * @return  A status about the modification.
     */
    @PUT
    @Path("/{title}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(FilmDTO film) {
        Film f = manager.getFilm(film.getTitle());
        if(f == null) {
            return Response
                    .status(404)
                    .build();
        }
        else
        {
            manager.update(f, f.getTitle());
            return Response
                    .ok()
                    .build(); 
        }
            
    }
}
