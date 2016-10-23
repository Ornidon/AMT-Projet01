package com.mycompany.projet.services;
import com.mycompany.projet.models.User;
import javax.ejb.Local;

/**
 * Interface for the communication methods with the Datbase for the Users
 * 
 * @author Ioannis Noukakis & Thibaut Loiseau
 */
@Local
public interface UserManagerLocal {
    int create(String username, String password);
    User get(String username, String password); 
}
