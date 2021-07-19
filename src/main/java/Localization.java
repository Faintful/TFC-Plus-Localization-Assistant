public class Localization {

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

    public boolean verifyInputFile(String input) {
        return true;
    }
}
