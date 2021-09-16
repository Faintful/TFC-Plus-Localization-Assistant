package com.github.faintful.localizer;

public interface ErrorPrompter {

    public void promptInvalidInput(Localization localization);

    public void promptInvalidInvalidExtension(Localization localization);

    public void promptUnableToCreateFile();
}
