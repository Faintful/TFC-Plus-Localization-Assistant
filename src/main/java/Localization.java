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

    public boolean isValidFile(String input) {
        return isValidPath(input) && isValidFileFormat(input);
        }

    private boolean isValidFileFormat(String path) {
        Pattern pattern = Pattern.compile("^.*(.lang)$");
        Matcher matcher = pattern.matcher(path);
        return matcher.matches();
    }

    private boolean isValidPath(String input) {
        return new File(input).exists();
    }
}