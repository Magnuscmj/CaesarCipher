package com.ComputasHomeTask;

public class CaesarCipher {

    static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static String encoding(String plainText, int Key) {
        plainText = plainText.toLowerCase();
        StringBuilder chiperText = new StringBuilder(" ");

        for (int i = 0; i < plainText.length(); i++) {
            int charIndex = alphabet.indexOf(plainText.charAt(i));
            int newIndex = (charIndex + Key) % 26;
            char chipherChar = alphabet.charAt(newIndex);
            chiperText.append(chipherChar);
        }
        return chiperText.toString();
    }


    public static String decoding(String chiperText, int Key) {
        String plainText = " ";

        for (int i = 0; i < chiperText.length(); i++) {
        int charIndex = alphabet.indexOf(chiperText.charAt(i));
        int newIndex = (charIndex - Key) % 26;

    }



    public static void main(String[] args) {
	// write your code here
    }
}
