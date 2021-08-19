package com.github.faintful.localizer;

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
        System.out.println("\n" + "Invalid character at index " + Integer.sum(localization.invalidPathException.getIndex(), 1) + "\n" +
                "Your input was: " + "\"" + localization.getInput() + "\"" + "\n" +
                "Please exclude invalid characters from your input and try again");
    }

    public void promptInvalidExtension() {

    }
}