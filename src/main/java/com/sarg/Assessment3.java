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


    private boolean startsWithVowel(String word) {
        return CHAR_VOWELS.indexOf(word.charAt(0)) >=0;
    }

    private String addCharsToTheEnd(String word, String charsToBeAdded) {
        return word + charsToBeAdded;
    }

    private String moveFirstLetterToTheEnd(String word) {
        boolean wordWithCapital = startsWithUppercase(word);
        String convertedWord;
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

    private boolean startsWithUppercase(String word){
        return Character.isUpperCase(word.charAt(0));
    }
}
