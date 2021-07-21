import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationTest {

    //TODO: This test must ensure that the app has received a String as an input
    @Test
    public void didYouEnterAnObject(){
        //arrange
        //FIXME: "Test data as if from user" isn't necessary. Make test more concise.
        Prompter prompter = new Prompter((str) -> {}, () -> "Test");
        Localization inputFile = new Localization(prompter);
        //act
        inputFile.setInput("This is a string");
        //assess
        assertNotNull(inputFile.getInput());
    }

    //TODO: This test must ensure that the input that the app has received is a user-prompted input
    @Test
    public void theUserIsPromptedForAnInput() {
        //arrange
        //act
        Localization inputFile = new Localization(new Prompter((str) -> {System.out.println("Please enter an input:");}, () -> "This is a user generated input"));
        //assess
        assertNotNull(inputFile.getInput());
    }

    //TODO: This next test must ensure that the input the the user has entered is a valid path for a .lang file
    @Test
    public void doesTheEnteredPathEndWithDotLang() {
        //arrange
        Localization inputFile = new Localization(new Prompter((str) -> {}, () -> "C:\\Users\\Skye\\IdeaProjects\\TFC+ Localization Assistant\\src\\main\\resources\\it_IT.lang"));
        //act
        //assess
        assertTrue(inputFile.verifyInputFileFormat(inputFile.getInput()));
    }
}