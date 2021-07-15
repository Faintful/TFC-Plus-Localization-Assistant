public class Localization {

    private Object userInput;

    public Localization(Prompter prompter) {
        setInput(prompter.promptForInput());
    }

    public Object getInput() {
        return userInput;
    }

    public void setInput(Object userInput) {
        this.userInput = userInput;
    }
}
