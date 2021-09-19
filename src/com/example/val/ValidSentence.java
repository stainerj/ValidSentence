package com.example.val;

import java.util.Scanner;

/**
 * ValidSentence class to determine whether sentence entered by user is valid
 * @author Jonathan
 * @version 1.0
 * @since 2021-09-19
 */
public class ValidSentence {

    public static Scanner keyboard = new Scanner(System.in);//input stream
    public static String sentence;

    /**
     * main method
     */
    public static void main(String[] args) {
        getInput();
    }

    /**
     * getInput method (void) to get user input and output result
     */
    public static void getInput() {
        do {
            System.out.println("Please enter sentence input, or x to exit:");
            sentence = keyboard.nextLine();
            if(sentenceValidator(sentence)){
                System.out.println("Input string is a valid sentence.");
            }
            else if (!sentenceValidator(sentence)){
                System.out.println("Input string is not a valid sentence.");
            }
        } while (!sentence.equals("x"));
    }

    /**
     * sentenceValidator method to determine sentence validity
     *
     * @param input     String (sentence input)
     * @return isValid  boolean (whether or not sentence is valid)
     */
    public static boolean sentenceValidator(String input){
        boolean isValid = false;

        //Check that input string starts with a capital letter
        boolean firstLetter = Character.isUpperCase(input.charAt(0));

        //check that number of quotation marks is even
        char quot = '"';
        int countQuot = 0;
        for (int i = 0; i < input.length(); i++){
            if(input.charAt(i) == quot){
                countQuot ++;
            }
        }
        boolean evenQuot = false;
        if(countQuot % 2 == 0){
            evenQuot = true;
        }

        //Check final character is full stop
        boolean lastChar = false;
        char fullStop = '.';
        int countFullStop = 0;
        if (input.charAt(input.length()-1) == fullStop){
            lastChar = true;
        }

        //Count number of full stops
        for (int i = 0; i < input.length(); i++){
            if(input.charAt(i) == fullStop){
                countFullStop ++;
            }
        }
        boolean onlyOneFullStop = false;

        if (countFullStop == 1){
            onlyOneFullStop = true;
        }

        //Check if there are numeric strings for numbers below 13
        String[] invalidNumericStrings = {" 1 ", " 2 ", " 3 ", " 4 ", " 5 ", " 6 ", " 7 ", " 8 ", " 9 ", " 10 ", " 11 ", " 12 "};
        boolean containsInvalidString = false;
        for (String invalid: invalidNumericStrings){
            if(input.contains(invalid)){
                containsInvalidString = true;
            }
        }

        //determine sentence validity
        isValid = firstLetter && evenQuot && lastChar && onlyOneFullStop && (!containsInvalidString);

        return isValid;
    }
}
