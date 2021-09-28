package com.ComputasHomeTask;

import java.util.Scanner;

public class CaesarCipher {

    static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static String encoding(String plainText, int Key) {
        plainText = plainText.toLowerCase();
        StringBuilder chiperText = new StringBuilder(" ");

        for (int i = 0; i < plainText.length(); i++) {
            int charIndex = alphabet.indexOf(plainText.charAt(i));
            int newIndex = ( charIndex + Key ) % 26;
            char chipherChar = alphabet.charAt(newIndex);
            chiperText.append(chipherChar);
        }

        return chiperText.toString();
    }


    public static String decoding(String chiperText, int Key) {
        StringBuilder plainText = new StringBuilder(" ");

        for (int i = 0; i < chiperText.length(); i++) {
        int charIndex = alphabet.indexOf( chiperText.charAt(i) );
        int newIndex = ( charIndex - Key ) % 26;
        if ( newIndex < 0 ) {
            newIndex = alphabet.length() + newIndex;
        }
        char plainChar = alphabet.charAt( newIndex );
        plainText.append(plainChar);
        }

        return plainText.toString();
    }



    public static void main(String[] args) {
	    //This how we can interact with the program
        Scanner scan = new Scanner( System.in );
        //allows the user to type with "spaces"
        System.out.print( "Enter plain text: " );
        String plainText = scan.next();

        System.out.print( "Enter Key: " );
        int Key = scan.nextInt();

        String chiperText = encoding( plainText, Key );

        System.out.println("The chipher text: " + chiperText);

        System.out.println("The decoded message is: " + decoding(chiperText, Key));
    }
}
