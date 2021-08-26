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

    InvalidPathException invalidPathException = null;
    IllegalArgumentException illegalArgumentException = null;
    Path path = null;

    private String userInput;

//    @Deprecated
    //Might create a third class in the future that fulfills the function inside the scope of this constructor
    public Localization(Prompter prompter) {
        setInput(prompter.promptForInput());
    }

    public String getInput() {
        return userInput;
    }

    public InvalidPathException getInvalidPathException() {
        return invalidPathException;
    }

    public void setInput(String userInput) {
        this.userInput = userInput;
    }

    public boolean isValidFile(String input, String message) {
        return isValidPath(input) && isValidExtension(input, message);
    }

    public boolean isValidExtension(String path, String message) {
        Pattern pattern = Pattern.compile("^.*(.lang)$");
        Matcher matcher = pattern.matcher(path);
        return saveIllegalArgumentException(path, message, matcher.matches());
    }

    public boolean saveIllegalArgumentException(String path, String message, boolean bool) {
        try {
            if (bool) {
                throw new IllegalArgumentException(message);
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            this.illegalArgumentException = illegalArgumentException;
            return false;
        }
        return true;
    }

    public boolean isValidPath(String path) {
        return Optional.ofNullable(saveInvalidPathException(path)).isPresent();
    }

    public Path saveInvalidPathException(String path) {
        try {
            return Paths.get(path);
        } catch (InvalidPathException invalidPathException) {
            this.invalidPathException = invalidPathException;
            return null;
        }
    }

    @Deprecated
    private boolean canCreateFile(String path) {
        return new File(path).exists();
    }

}