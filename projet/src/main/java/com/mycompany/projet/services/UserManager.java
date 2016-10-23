/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projet.services;

import com.mycompagny.security.SHA256Util;
import com.mycompany.projet.models.User;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author Ornidon
 */
@Stateless
public class UserManager implements UserManagerLocal {
    
    @EJB
    private MySQLCommon QueryExecutor;
    
    private final String GET_USER_QUERY = "SELECT * FROM user WHERE username=? AND password=?";
    private final String GET_USER_WOPWD = "SELECT * FROM user WHERE username=? ";
    private final String CREATE_USER_QUERY = "INSERT INTO user (username, password) VALUES (?,?)" ;
    
    
    @Override
    public int create(String username, String password) {
        ResultSet rs = QueryExecutor.doQuery(GET_USER_WOPWD, username);
        try {
            if(rs != null && rs.next()) return 0;
            else return QueryExecutor.doUpdateQuerry(CREATE_USER_QUERY, username, SHA256Util.get_SHA_256_SecurePassword(password, "rsdetizug"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public User get(String username, String password)  {
        
        User user = null;
        try {
            ResultSet rs = QueryExecutor.doQuery(GET_USER_QUERY, username, SHA256Util.get_SHA_256_SecurePassword(password, "rsdetizug"));
            if (rs.next()) {  
                user = new User(username, password,  rs.getInt("user_id"));
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }   
    
}

