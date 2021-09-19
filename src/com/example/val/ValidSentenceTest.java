package com.example.val;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ValidSentenceTest class to test ValidSentence class
 * @author Jonathan
 * @version 1.0
 * @since 2021-09-19
 */
public class ValidSentenceTest {

    /**
     * sentenceValidTest (void) - test for valid sentences - sentenceValidator should return true
     *
     * @param input     String
     */
    @ParameterizedTest
    @ValueSource(strings = {"The quick brown fox said “hello Mr lazy dog”.",
            "The quick brown fox said hello Mr lazy dog.",
            "One lazy dog is too few, 13 is too many.",
            "One lazy dog is too few, thirteen is too many."})
    void sentenceValidTest(String input){
        assertTrue(ValidSentence.sentenceValidator(input));
    }

    /**
     * sentenceInvalidTest (void) - test for non-valid sentences - sentenceValidator should return false
     *
     * @param input     String
     */
    @ParameterizedTest
    @ValueSource(strings = {"The quick brown fox said \"hello Mr. lazy dog\".",
            "the quick brown fox said “hello Mr lazy dog\".",
            "\"The quick brown fox said “hello Mr lazy dog.\"",
            "One lazy dog is too few, 12 is too many."})
    void sentenceInvalidTest(String input){
        assertFalse(ValidSentence.sentenceValidator(input));
    }
}
