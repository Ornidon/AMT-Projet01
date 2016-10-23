package com.mycompagny.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Class permettant de hasher une chaine de caractères en utilisant SHA256.
 * 
 * @author Ioannis Noukakis & Thibaut Loiseau
 */
public class SHA256Util {

    /**
     * Hash une chaîne de caractères en utilisant SHA256
     * 
     * @param passwordToHash: la chaine à hasher
     * @param salt          : le "sel" avec le quel hasher la chaine
     * 
     * @return la chaine hashée
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException 
     */
    public static byte[] get_SHA_256_SecurePassword(String passwordToHash, String salt) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt.getBytes("UTF-8"));
        return md.digest(passwordToHash.getBytes("UTF-8"));
    }
}
