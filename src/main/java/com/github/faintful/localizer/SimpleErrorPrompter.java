package com.github.faintful.localizer;

public class SimpleErrorPrompter implements ErrorPrompter{

    @Override
    public void promptInvalidInput(Localization localization) {
        System.out.println("Unable to parse in your input. Invalid character. Please try again or press 1 for further details.");
    }

    @Override
    public void promptInvalidInvalidExtension(Localization localization) {

    }

    @Override
    public void promptUnableToCreateFile() {

    }
}
