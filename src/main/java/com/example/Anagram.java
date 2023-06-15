package com.example;

import java.util.List;

/**
 * Class representing an Anagram containing 2 attributes to be compared.
 *
 * @param text1 a simple String to be compared.
 * @param text2 a simple String to be compared.
 * @author Rodrigo Farias
 */
public class Anagram {

    private String text1;
    private String text2;

    public Anagram(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

    /**
     * <p>Method responsible for sanitizing and verifying whether the Object is an anagram or not.</p>
     *
     * @return a Boolean value indicating whether Object {@link com.example.Anagram} is an anagram or not
     */
    public boolean isAnagram() {
        this.sanitises();
        return this.checksSize(this) && this.checksIfTheOrderOfCharactersAreEqual(this);
    }

    /**
     * <p>Method responsible for removing white spaces, remove special characters and convert Text1 and Text2 attributes to Lowercase.</p>
     */
    private void sanitises() {
        this.removesWhitespaces();
        this.removeSpecialCharacters();
        this.toLowerCase();
    }

    /**
     * <p>Method responsible for removing white spaces.</p>
     */
    private void removesWhitespaces() {
        this.text1 = text1.replaceAll("\\s", "");
        this.text2 = text2.replaceAll("\\s", "");
    }

    /**
     * <p>Method responsible for remove special characters.</p>
     */
    private void removeSpecialCharacters() {
        var regex = "[^a-zA-Z0-9 ]";
        this.text1 = text1.replaceAll(regex, "");
        this.text2 = text2.replaceAll(regex, "");
    }

    /**
     * <p>Method responsible for convert Text1 and Text2 attributes to Lowercase.</p>
     */
    private void toLowerCase() {
        this.text1 = text1.toLowerCase();
        this.text2 = text2.toLowerCase();
    }

    /**
     * <p>Method verifies if the attributes Text1 and Text2 have the same size of characters.</p>
     */
    private boolean checksSize(Anagram anagram) {
        return anagram.getText1().length() == anagram.getText2().length();
    }

    /**
     * <p>Method responsible for converting the attributes Text1 and Text2 into lists of Character, sort and then check if they are equal.</p>
     */
    private boolean checksIfTheOrderOfCharactersAreEqual(Anagram anagram) {
        List<Character> characterList1 = anagram.getText1().chars()
                .mapToObj(c -> (char) c)
                .sorted().toList();

        List<Character> characterList2 = anagram.getText2().chars()
                .mapToObj(c -> (char) c)
                .sorted().toList();

        return characterList1.equals(characterList2);
    }
}
