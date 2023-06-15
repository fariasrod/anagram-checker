package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    @DisplayName("WHEN trying to check if 2 texts are an anagram THEN the result should be TRUE")
    public void testAreAnagramsCase1() {
        Anagram anagram = new Anagram("below", "elbow");

        assertTrue(Main.checksAnAnagram(anagram));
    }

    @Test
    @DisplayName("WHEN trying to check if 2 texts with white spaces are an anagram THEN the result should be TRUE")
    public void testAreAnagramsCase2() {
        Anagram anagram = new Anagram("below ", " el bow ");

        assertTrue(Main.checksAnAnagram(anagram));
    }

    @Test
    @DisplayName("WHEN trying to check if 1 lowercase text and 1 uppercase text are an anagram THEN the result should be TRUE")
    public void testAreAnagramsCase3() {
        Anagram anagram = new Anagram("below", "ELBOW");

        assertTrue(Main.checksAnAnagram(anagram));
    }

    @Test
    @DisplayName("WHEN trying to check if 2 texts with special characters are an anagram, they will be removed THEN the result should be TRUE")
    public void testAreAnagramsCase4() {
        Anagram anagram = new Anagram("below@ ", " elbow#");

        assertTrue(Main.checksAnAnagram(anagram));
    }

    @Test
    @DisplayName("When trying to check if 2 texts that are not an anagram are an anagram then the result should be FALSE")
    public void testAreNotAnagramsCase1() {
        Anagram anagram = new Anagram("hello", "world");

        assertFalse(Main.checksAnAnagram(anagram));
    }

    @Test
    @DisplayName("When trying to check if 2 texts that are not an anagram are an anagram then the result should be FALSE")
    public void testAreNotAnagramsCase2() {
        Anagram anagram = new Anagram("below", "elboww");

        assertFalse(Main.checksAnAnagram(anagram));
    }
}
