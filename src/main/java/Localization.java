// It's a little wasteful to create a class
// For exactly one use
// Generally make static methods for single uses
// Classes should be made for a single domain (but multiple uses, or for passing around)

// This is abstract as to not be instantiated, since everything in it is static
// If you find more use cases for a Localization class, you can remove the abstract
abstract public class Localization {
    public static String fromPrompter(Prompter prompter) {
        return prompter.promptForInput();
    }
}
