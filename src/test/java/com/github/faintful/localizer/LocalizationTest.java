package com.github.faintful.localizer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationTest {

    //TODO: This test must ensure that the app has received a String as an input
    @Test
    public void didYouEnterAnObject(){
        //arrange
        Prompter prompter = new Prompter((str) -> {}, () -> "Test");
        Localization inputFile = new Localization(prompter);
        //act
        inputFile.setInput("This is a string");
        //assess
        assertNotNull(inputFile.getInput());
    }

    //TODO: This test must ensure that the input that the app has received is a user-prompted input
    @Test
    public void isItAUserPromptedInput() {
        //arrange
        //act
        Localization inputFile = new Localization(new Prompter(System.out::println, () -> "This is a user generated input"));
        //assess
        assertNotNull(inputFile.getInput());
    }

    //TODO: This next test must ensure that the input that the user has entered is a path containing valid characters
    @Test
    public void isItAValidPath() {
        //arrange
        Localization inputFile = new Localization(new Prompter((str) -> {}, () -> "C:\\Users\\Skye\\IdeaProjects\\TFC+ Localization Assistant\\src\\main\\resources\\it_IT.lang"));
        //act
        //assess
        assertTrue(inputFile.isValidPath(inputFile.getInput()));
    }

    //TODO: This test must ensure that in the eventuality that an exception is thrown by the above test, the exception is recorded to a class variable to be used by the Prompter class in the future
    @Test
    public void isTheExceptionSaved() {
        //arrange
        Localization inputFile = new Localization(new Prompter((str) -> {}, () -> "Invalid characters : ; * . ,"));
        //act
        inputFile.saveInvalidPathException(inputFile.getInput());
        //assess
        assertNotNull(inputFile.getInvalidPathException());
    }

    //TODO: This next test must ensure that the input that the user has entered is a valid path for a .lang file extension
    @Test
    public void isItAValidFileExtension() {
        //arrange
        Localization inputFile = new Localization(new Prompter((str) -> {}, () -> "C:\\Users\\Skye\\IdeaProjects\\TFC+ Localization Assistant\\src\\main\\resources\\it_IT.lang"));
        //act
        //assess
        assertTrue(inputFile.isValidExtension(inputFile.getInput(), "Dinky Wink"));
    }

    //TODO: This next test must ensure that the validateExtension() method throws an Illegal Argument Exception in the case that it returns false, and that the exception is saved as a class variable.
    @Test
    public void testTestTest() {
        //arrange
        Localization inputFile = new Localization(new Prompter((str) -> {}, () -> "C:\\Users\\Skye\\IdeaProjects\\TFC+ Localization Assistant\\src\\main\\resources\\it_IT.lang"));
        //act
        //assess

    }
}