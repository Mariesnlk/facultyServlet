package com.example.faculty;

public class FieldsValidator {

    public static final String LETTERS = "Aa";

    public static boolean isCorrectWord(String word) {

        char[] lettersOfWord = word.toCharArray();

        for (char c : lettersOfWord) {
            int index = LETTERS.indexOf(c);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isCorrectWord("aAaaaaA"));
        System.out.println(isCorrectWord("aAaaa1A"));
    }
}