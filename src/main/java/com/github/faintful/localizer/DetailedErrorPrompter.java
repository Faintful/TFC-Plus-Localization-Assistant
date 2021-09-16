package com.github.faintful.localizer;

import java.nio.file.InvalidPathException;

public class DetailedErrorPrompter implements ErrorPrompter{

    @Override
    public void promptInvalidInput(Localization localization) {
        localization.invalidPathException = new InvalidPathException("ayy", "ayyLmao", 1);
        System.out.println("\n" + "Error of type: " + localization.invalidPathException.getReason() + "at index " + Integer.sum(localization.invalidPathException.getIndex(), 1) + "\n" +
                "Your input was: " + "\"" + localization.getInput() + "\"");
    }

    @Override
    public void promptInvalidInvalidExtension(Localization localization) {

    }

    @Override
    public void promptUnableToCreateFile() {

    }

}
