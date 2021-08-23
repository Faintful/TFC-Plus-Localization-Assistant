import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationTest {
    // Extracted variable since we don't want to mess up the test
    // by writing the string differently by mistake in 2-3 places
    final static String expectedValue = "Test data as if from user";

    //TODO: This test must ensure that the app has received an object as an input
    @Test
    public void didYouEnterAnObject(){
        //arrange
        Prompter prompter = Prompter.readOnly(expectedValue);
        String result = Localization.fromPrompter(prompter);
        //act
        //assess
        assertNotNull(result);
    }

    //TODO: This test must ensure that the input that the app has received is a user-prompted input
    @Test
    public void theUserIsPromptedForAnInput() {
        //arrange
        //act
        String returnedValue = Localization.fromPrompter(Prompter.readOnly(expectedValue));
        //assess
        assertEquals(expectedValue, returnedValue);
    }
}