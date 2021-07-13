import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationTest {

    //TODO: This test must ensure that the app has received an object as an input
    @Test
    public void didYouEnterAnObject(){
        //arrange
        Localization inputFile = new Localization();
        //act
        inputFile.setInput(0);
        //assess
        assertNotNull(inputFile.getInput());
    }
}