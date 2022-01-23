package com.sarg;

import java.util.ArrayList;
import java.util.List;

public class Assessment3 {

    private final String CHAR_AY = "ay";
    private final String CHAR_VOWELS = "aeiouAEIOU";
    private final String CHAR_WAY = "way";

    /**
     * Applies the following filters to the words
     * - Move the first letter of each word to the end of the word.
     * - Add "ay" to the end of the word.
     * - Words starting with a vowel (a,e,i,o,u, A, E, I, O, U) simply have "way" appended to the end.
     * @param words words that the function applies filters to
     * @return the new words
     * @throws Exception if we call the function with null params
     */
    public String doRemake(String words) throws Exception {
        if(words == null){
            throw new Exception("words to remake should not be null");
        }
        words = words.replace(".","");
        List<String> newWordsList = new ArrayList<>();
        String[] wordsList = words.split(" ");
        for (String word : wordsList){
            String filteredWord ="";
            if(startsWithVowel(word)){
                filteredWord =  addCharsToTheEnd(word, CHAR_WAY);
            } else {
                filteredWord = moveFirstLetterToTheEnd(word);
                filteredWord = addCharsToTheEnd(filteredWord, CHAR_AY);
            }
            newWordsList.add(filteredWord);
        }

        return String.join(" ", newWordsList) + ".";
    }

    /**
     * Checks if the word starts with a vowel
     * @param word the word that is checked
     * @return true if the word starts with vowel, otherwise false
     * @throws Exception thrown if the word is null
     */
    private boolean startsWithVowel(String word) throws Exception {
        if(word == null){
            throw new Exception("word should not be null");
        }
        return CHAR_VOWELS.indexOf(word.charAt(0)) >=0;
    }

    /**
     * Updates a word and add the specified characters at the end.
     * @param word the word that is updated
     * @param charsToBeAdded the character that the function adds at the end of the word
     * @return the updated word
     * @throws Exception thrown if the word is null
     */
    private String addCharsToTheEnd(String word, String charsToBeAdded) throws Exception {
        if(word == null || charsToBeAdded == null){
            throw new Exception("word or char to be added should not be null");
        }
        return word + charsToBeAdded;
    }

    /**
     * Moves the first letter of the word to the end.
     * @param word the word that is updated
     * @return the updated word
     * @throws Exception is thrown if the word is null
     */
    private String moveFirstLetterToTheEnd(String word) throws Exception {
        if(word == null){
            throw new Exception("word should not be null");
        }
        boolean wordWithCapital = startsWithUppercase(word);
        String convertedWord = "";
        int length = word.length();
        if (length <= 1) {
            return word;
        } else {
            convertedWord = word.substring(1, length) + word.toLowerCase().charAt(0);
            if(wordWithCapital){
                convertedWord = convertedWord.substring(0,1).toUpperCase() + convertedWord.substring(1);
            }

            return convertedWord;
        }

    }

    /**
     * Checks if the word starts with an uppercase letter.
     * @param word the word to be checked.
     * @return true if the word starts with uppercase, otherwise false.
     * @throws Exception is thrown if the word is null
     */
    private boolean startsWithUppercase(String word) throws Exception {
        if(word == null){
            throw new Exception("word should not be null");
        }

        return Character.isUpperCase(word.charAt(0));
    }
}
