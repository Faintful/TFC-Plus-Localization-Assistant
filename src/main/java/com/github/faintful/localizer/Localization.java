package com.github.faintful.localizer;

import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
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
        return isValidPath(input) && isValidExtension(input);
        }

    public boolean isValidExtension(String path) {
        Pattern pattern = Pattern.compile("^.*(.lang)$");
        Matcher matcher = pattern.matcher(path);
        return matcher.matches();
    }

    public boolean isValidPath(String path) {
        return verifyPath(path).isPresent();
    }

    public Optional<Path> verifyPath(String path) {
        try {
            return Optional.of(Paths.get(path));
        } catch (InvalidPathException exception) {
            return Optional.empty();
        }
    }

    @Deprecated
    private boolean canCreateFile(String path) {
        return new File(path).exists();
    }

}