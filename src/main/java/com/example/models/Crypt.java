package com.example.models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;

public class Crypt {

    static final String ALGORITHM = "SHA-1";

    public static String hash(String pass) {
        try {
            return tryHash(pass);
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
            return new String();
        }
    }
    
    public static String tryHash(String pass) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance(ALGORITHM);
        byte[] byteArray = pass.getBytes();
        md.update(byteArray);
        byte[] resultArray = md.digest();
        String baseCoded = Base64.getEncoder().encodeToString(resultArray);
        return baseCoded;
    }

    public static String generateSalt(int size) {

        
        String abc = "0123456789ABCDEFGHIJKLMNOPQRSTUVXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuffer salt = new StringBuffer();
        for(int i = 0; i < size; i++){
            salt.append(abc.charAt(random.nextInt(abc.length())));
        }
        return salt.toString();
    }

    // public static void main(String[] args) {
    //     String res = generateSalt(8);
    //     System.out.println(res.length());
    //     System.out.println("Eredmény: " + res);
    // }
}
