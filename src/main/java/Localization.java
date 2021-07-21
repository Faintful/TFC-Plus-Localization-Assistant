import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Localization {

    File file;
    private String userInput;

    public Localization(Prompter prompter) {
        setInput(prompter.promptForInput());
    }

    public String getInput() {
        return userInput;
    }

    public void setInput(String userInput) {
        this.userInput = userInput;
    }

    //FIXME: This method is doing two things at once. Make them into their own methods and allow this method to implement both.
    public boolean verifyInputFileFormat(String input) {
        Pattern pattern = Pattern.compile("^.*(.lang)$");
        Matcher matcher = pattern.matcher(input);
        file = new File(input);
        return file.exists() && matcher.matches();
        }
    }