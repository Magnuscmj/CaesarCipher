package com.ComputasHomeTask;
import java.util.Scanner;


public class CaesarCipher {

    static String alphabet = "abcdefghijklmnopqrstuvwxyzæøå";

    public static String encoding(String plainText, int Key) {
        plainText = plainText.toLowerCase();
        StringBuilder chiperText = new StringBuilder();

        //Loop trough plainText to find matches in the alphabet String
        for (int i = 0; i < plainText.length(); i++) {
            int charIndex = alphabet.indexOf(plainText.charAt(i));
            int newIndex = (charIndex + Key) % 29;
            char chipherChar = alphabet.charAt(newIndex);
            chiperText.append(chipherChar);
        }
        return chiperText.toString();
    }


    public static String decoding(String chiperText, int Key) {
        StringBuilder plainText = new StringBuilder(" ");

        for (int i = 0; i < chiperText.length(); i++) {
            int charIndex = alphabet.indexOf(chiperText.charAt(i));
            int newIndex = (charIndex - Key) % 29;

        if (newIndex < 0) {
            newIndex = alphabet.length() + newIndex;
        }
        char plainChar = alphabet.charAt(newIndex);
            plainText.append(plainChar);
        }
        return plainText.toString();
    }

    public static void main(String[] args) {

	    // Import of the scanner and the input stream
        Scanner scan = new Scanner(System.in);

        // Gives the user access to the plain text input
        System.out.print("Enter plain text:");
        String plain = scan.nextLine();

        // Input for the number of times they wish to switch
        System.out.print("Enter number of switches:");
        int Key = scan.nextInt();

        // Prints out the encrypted message and decrypts it again
        String chiperText = encoding(plain, Key);
        System.out.println("The chipher text: " + chiperText);
        System.out.println("The decoded message is:" + decoding(chiperText, Key));
    }
}
