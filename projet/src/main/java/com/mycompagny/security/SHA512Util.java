/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author durza
 */
public class SHA512Util {
    public static byte[] get_SHA_512_SecurePassword(String passwordToHash, String salt) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String generatedPassword = null;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt.getBytes("UTF-8"));

        return md.digest(passwordToHash.getBytes("UTF-8"));
    }
}
