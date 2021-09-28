package com.ComputasHomeTask;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


public class CaesarCipher {

    static String alphabet = "abcdefghijklmnopqrstuvwxyzæøå";

    public static String encoding(String plainText, int Key) {

        plainText = plainText.toLowerCase();  //We make chiperText a Method
        StringBuilder chiperText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {  //Loop trough plainText to find matches in the alphabet String
            int charIndex = alphabet.indexOf(plainText.charAt(i));
            int newIndex = (charIndex + Key) % 29;
            char chipherChar = alphabet.charAt(newIndex);
            chiperText.append(chipherChar);
        }
        return chiperText.toString();
    }


    public static String decoding(String chipherText, int Key) {
        StringBuilder plainText = new StringBuilder(" ");

        for (int i = 0; i < chipherText.length(); i++) {  //Looping trough cipherText reversing the process above
            int charIndex = alphabet.indexOf(chipherText.charAt(i));
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

        String data = null; //Reads the String of "message.txt" file

        try {
            File myObj = new File("message.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                System.out.println("message.txt: " + data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Scanner scan = new Scanner(System.in);   //Import of the scanner and the input stream
        System.out.print("Enter number of switches: "); //Input for the number of times they wish to switch
        int Key = scan.nextInt();

        String chiperText = encoding(data, Key); //Prints out the encrypted message and decrypts it again
        System.out.println("The cipher text: " + chiperText);
        System.out.println("The decoded message is:" + decoding(chiperText, Key));
    }
}
