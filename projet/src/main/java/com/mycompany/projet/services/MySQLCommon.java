/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projet.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author Ornidon
 */
@Stateless
public class MySQLCommon {
    @Resource(lookup = "jdbc/sakila")
    DataSource database;
    private Connection mConnection = null;
    
    public ResultSet doQuery(String query, Object... args) {
        try {
            // Connection with the database
            if(mConnection == null) mConnection = database.getConnection();
            System.out.println(mConnection.getSchema());
            PreparedStatement stmt = mConnection.prepareStatement(query);
            
            if(args != null){
                for (int i = 0; i < args.length; i++) {
                    stmt.setObject(i + 1, args[i]);
                }
            }
            return stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void endConnect(){
        if(mConnection != null){
            try {
                mConnection.close();
                mConnection = null;
            } catch (SQLException ex) {
                Logger.getLogger(MySQLCommon.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public int doUpdateQuerry(String query, Object... args) throws SQLException {
        try {
            // Connection with the database
            if(mConnection == null) mConnection = database.getConnection();
            PreparedStatement stmt = mConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            if(args != null){
                for (int i = 0; i < args.length; i++) {
                    stmt.setObject(i + 1, args[i]);
                }
            }
            stmt.executeUpdate();
            // We are looking for the eventual id in the case of an insertion query
            ResultSet keys = stmt.getGeneratedKeys();

            if (keys.next()) {
               return keys.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
}
