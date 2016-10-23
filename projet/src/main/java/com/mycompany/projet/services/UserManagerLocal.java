package com.mycompany.projet.services;
import com.mycompany.projet.models.User;
import javax.ejb.Local;

/**
 *
 * @author Ornidon
 */
@Local
public interface UserManagerLocal {
    int create(String username, String password);
    User get(String username, String password); 
}
