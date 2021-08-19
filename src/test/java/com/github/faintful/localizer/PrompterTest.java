package com.github.faintful.localizer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class PrompterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams(){
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void qualityControl(){
        System.out.println("hello");
        assertEquals("hello\r\n", outContent.toString());
    }

    @Test
    public void isItAUserPromptedInput() {
        //arrange
        //act
        Localization inputFile = new Localization(new Prompter((str) -> {System.out.println("Please enter an input:");}, () -> "This is a user generated input"));
        //assess
        assertEquals("Please enter an input:\r\n", outContent.toString());
    }

    @Test
    public void promptInvalidPath() {
        //arrange
        Localization inputFile = new Localization(new Prompter((str) -> {System.out.println("Please enter an input:");}, () -> "This is a user generated input"));
        //act

        //assess
        //TODO: Create method that displays the error message of the exception that was caught
        assertEquals("Invalid characters in the path\r\n", outContent.toString());
    }

    @Test
    public void promptInvalidExtension() {
        //arrange
        //act
        Localization inputFile = new Localization(new Prompter((str) -> {System.out.println("Please enter an input:");}, () -> "This is a user generated input"));
        //assess
        assertEquals("Please enter an input:\r\n", outContent.toString());
    }

    @Test
    public void promptCannotCreateFile() {
        //arrange
        //act
        Localization inputFile = new Localization(new Prompter((str) -> {System.out.println("Please enter an input:");}, () -> "This is a user generated input"));
        //assess
        assertEquals("Please enter an input:\r\n", outContent.toString());
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
