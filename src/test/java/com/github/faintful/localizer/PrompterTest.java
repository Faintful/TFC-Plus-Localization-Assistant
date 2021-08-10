package com.github.faintful.localizer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrompterTest {

    @Test
    public void isItAUserPromptedInput() {
        //arrange
        //act
        Localization inputFile = new Localization(new Prompter((str) -> {System.out.println("Please enter an input:");}, () -> "This is a user generated input"));
        //assess
        assertNotNull(inputFile.getInput());
    }
}
