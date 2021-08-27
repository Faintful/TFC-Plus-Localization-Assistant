package com.github.faintful.localizer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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

    //TODO: This test isn't working. "Please enter an input" stays on top of the actual result. I don't know why.
    //Working now. Was a problem of the constructor of the Localization class not resetting the contents of its output stream and a text formatting with println()
    @Test
    public void promptInvalidPath() {
        //arrange
        Prompter prompter = new Prompter(System.out::println, () -> "This is a user generated input");
        Localization inputFile = new Localization(prompter);
        //act
        outContent.reset();
        prompter.promptInvalidInput(inputFile);
        //assess
        //TODO: Create method that displays the error message of the exception that was caught
        assertEquals("\nError of type: ayyLmaoat index 2\n" + "Your input was: \"This is a user generated input\"\r\n", outContent.toString());
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
