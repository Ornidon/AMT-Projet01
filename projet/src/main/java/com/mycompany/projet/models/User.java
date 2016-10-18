package com.mycompany.projet.models;

/**
 *
 * @author Ornidon
 */
public class User {
    private final String name;
    private final String password;
    private final int id;

    public User(String name, String password, int id) {
        this.name = name;
        this.password = password;
        this.id = id;
    }
    
    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
