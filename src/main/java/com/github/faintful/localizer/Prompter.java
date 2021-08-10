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
}