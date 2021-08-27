package com.github.faintful.localizer;

import java.nio.file.InvalidPathException;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Prompter {

    private final Consumer<String> writer;
    private final Supplier<String> reader;

    public Prompter(Consumer<String> writer, Supplier<String> reader) {
        this.writer = writer;
        this.reader = reader;
    }

    public String promptForInput() {
        writer.accept("Please enter an input:");
        return reader.get();
    }

    public void promptInvalidInput(Localization localization) {
        localization.invalidPathException = new InvalidPathException("ayy", "ayyLmao", 1);
        System.out.println("\n" + "Error of type: " + localization.invalidPathException.getReason() + "at index " + Integer.sum(localization.invalidPathException.getIndex(), 1) + "\n" +
                "Your input was: " + "\"" + localization.getInput() + "\"");
    }

    public void promptInvalidExtension() {

    }
}