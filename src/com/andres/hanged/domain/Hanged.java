package com.andres.hanged.domain;


import java.util.Random;
import java.util.Scanner;

public class Hanged {
    private String[] words = {"casa","ignorar","diseño","hipopotamo","vehiculo","carro"};
    private static final byte MAX_ATTEMPTS = 10;
    private String secretWord;
    private char[] secretWordHyphens;
    private Player player;

    private String chooseSecretWord(){
        Random r = new Random();
        int n = r.nextInt(words.length);
        this.secretWord = words[n];
        return secretWord;
    }

    public char[] getWordInHyphens(){
        this.chooseSecretWord();
        int lengthSecretWord = secretWord.length();
        secretWordHyphens = new char[lengthSecretWord];

        for (int i = 0; i < secretWordHyphens.length; i++) {
            secretWordHyphens[i] = '_';
        }
        return secretWordHyphens;
    }

    private void registerPlayer(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Enter your ID: ");
        int id = sc.nextInt();

        this.player = new Player(name,id);
    }

    public void play(){
        Scanner scanner = new Scanner(System.in);

        this.registerPlayer();
        System.out.println(this.player.getName() + ", Welcome to Hanged Game!");
        this.getWordInHyphens();

        boolean finishedGame = false;
        int attempts = 0;
        do {
            System.out.println(secretWordHyphens);
            System.out.println("Enter a letter: ");
            char letter = scanner.next().charAt(0);
            boolean correctLetter = false;
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == letter){
                    secretWordHyphens[i] = letter;
                    correctLetter = true;
                }
            }
            if (!correctLetter){
                System.out.println("Try again");
                attempts ++;

                if (attempts >= MAX_ATTEMPTS){
                    finishedGame = true;
                    System.out.println("You have reached the limit of attempts. The secret word was: " + secretWord);
                }
            } else if (String.valueOf(secretWordHyphens).equals(secretWord)) {
                    finishedGame = true;
            }
        }while (!finishedGame);
        if (String.valueOf(secretWordHyphens).equals(secretWord)){
            System.out.println("Congratulations, you have won! You guessed the secret word: " + secretWord);
        }
    }
}
