package com.mycompany.projet.services;

import com.mycompany.projet.models.Actor;
import com.mycompany.projet.models.Film;
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
    
    
}
