import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationTest {

    //TODO: This test must ensure that the app has received an object as an input
    @Test
    public void didYouEnterAnObject(){
        //arrange
        Prompter prompter = new Prompter(() -> "Test data as if from user", (str) -> {});
        Localization inputFile = new Localization(prompter);
        //act
        inputFile.setInput(0);
        //assess
        assertNotNull(inputFile.getInput());
    }

    //TODO: This test must ensure that the input that the app has received is a user-prompted input
    @Test
    public void theUserIsPromptedForAnInput() {
        //arrange
        //act
        Localization inputFile = new Localization(new Prompter(() -> "Test data as if from user", (str) -> {}));
        //assess
        assertEquals("Test data as if from user", inputFile.getInput());
    }
}